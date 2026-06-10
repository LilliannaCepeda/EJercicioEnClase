import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int opcion;

       do{
            System.out.print("==================================");
            System.out.print("  REGISTRO ESTUDIANTE EN ARCHIVO"); 
            System.out.println("==================================");
            System.out.println("\n1. Agregar Estudiante");
            System.out.println("2. Mostrar Estudiante");
            System.out.println("3. Salir");

            System.out.print("\nSelecciona una opcion: ");
            

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){

                case 1: registrarEstudainte();
                    break;
                case 2: mostrarEstudiante();
                    break;
                case 3: System.out.println("Saliendo...");
                    break;
                default: System.out.print("\nElige una opcion valida"); 
                    break;

            }

       }while(opcion != 3);

       scanner.close();

        
    }

    public static void registrarEstudainte(){

        
     try{
            FileWriter filewriter = new FileWriter("Estudiante.txt", true);
            
            System.out.print("\nIngrese el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la matricula: ");
            String matricula = scanner.nextLine();
            
            System.out.print("Ingrese la carrera: ");
            String carrera = scanner.nextLine();

            Estudiante estudiante = new Estudiante(nombre, matricula, carrera);
            
            BufferedWriter bufferedWriter = new BufferedWriter(filewriter);

            bufferedWriter.write(estudiante.getNombre());
            bufferedWriter.newLine();
            
            bufferedWriter.write(estudiante.getMatricula());
            bufferedWriter.newLine();
            
            bufferedWriter.write(estudiante.getCarrera());
            bufferedWriter.newLine();

            bufferedWriter.newLine();

            bufferedWriter.close();

            System.out.println("Estudiante Registrado correctamente");


        }catch (Exception e) {

        }

    }

    public static void mostrarEstudiante(){

        try{

            FileReader fileReader = new FileReader("Estudiante.txt");

            String nombre;
            String carrera;
            String matricula; 

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((nombre = bufferedReader.readLine()) != null) {

                matricula = bufferedReader.readLine();
                carrera = bufferedReader.readLine();
                bufferedReader.readLine();

                System.out.println("\nNombre: " + nombre);
                System.out.println("Matricula: " + matricula);
                System.out.println("Carrera: " + carrera);
            }

            bufferedReader.close();

        }catch(Exception e){

        }
    }
}
