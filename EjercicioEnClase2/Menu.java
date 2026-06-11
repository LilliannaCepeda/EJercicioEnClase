import java.util.Scanner;

public class Menu {

    static Paciente[] pacientes = new Paciente[3];
    static int totalRegistrados = 0;

    public static void main(String[] args){

        int opcion;
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------MENU-----------: \n\n");
        System.out.println("OPCIONES: \n");
        System.out.println("1.REGISTRAR PACIENTE: ");
        System.out.println("2.INFORMACION DE PACIENTES");
        System.out.println("3.CALCULAR IMC");
        System.out.println("4.DIAGNOSTICO DEL PESO DEL PASIENTE");
        System.out.println("5.Mostrar Todos los pacientes:");
        System.out.println("6.Salir");
        System.out.print("Elige una opcion: ");

        opcion = scanner.nextInt();
        scanner.nextLine();

         switch (opcion) {
                case 1: registrarPaciente(scanner);
                    break;
                case 2: mostrarInfoPaciente();       
                    break;
                case 3: mostrarDiagnostico();        
                    break;
                case 4: mostrarIMC();
                    break;
                case 5: mostrarPacientesTotal();  
                    break;
                case 6: System.out.println("Saliendo del sistema. ¡Hasta luego!"); break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 6);

        scanner.close();

    }

    public static void registrarPaciente(Scanner scanner){

        for(int i = 0; i < pacientes.length; i++){

             System.out.println("\n---Paciente " + (i +1 ) + "---\n");

            System.out.print("Ingrese el nombre del paciente: ");
            pacientes[i].setNombre(scanner.nextLine());
            scanner.nextLine();

            System.out.print("Ingrese la edad del paciente: ");
            pacientes[i].setEdad(scanner.nextInt());

            System.out.print("Ingrese el sexo del paciente: ");
            pacientes[i].setSexo(scanner.nextLine());

            System.out.print("Ingrese el peso del paciente paciente (en libras): ");
            pacientes[i].setPeso(scanner.nextInt());

            scanner.nextLine();
        
        }
    }

    public static void mostrarInfoPaciente(){

        if(totalRegistrados == 0){
            System.out.println("No hay pacinetes registrados");
        }

        for(int i = 0 ; i <totalRegistrados; i++){
            System.out.println("---Paciente " + (i + 1) + "---\n");
            System.out.println("Nombre: " + pacientes[i].getNombre());
            System.out.println("Edad: " + pacientes[i].getEdad());
            System.out.println("Sexo: " + pacientes[i].getSexo());
            System.out.println("Peso: " + pacientes[i].getPeso());
            System.out.println("Altura: " + pacientes[i].getAltura());
        }
    }

    public static double calcularIMC(int i){

        double pesoKg = pacientes[i].getPeso() * 0.453592;

        return pesoKg / (pacientes[i].getAltura() * pacientes[i].getAltura());

    }

      public static void mostrarIMC() {

        if (totalRegistrados == 0) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        for (int i = 0; i < totalRegistrados; i++) {
            System.out.printf("%nPaciente: %s  ->  IMC: %.2f%n",
                pacientes[i].getNombre(),
                calcularIMC(i));
        }
    }

     

    public static void mostrarPacientesTotal(){

         for(int i = 0; i < pacientes.length; i++){

            System.out.println("\n---Paciente " + (i +1 ) + "---\n");

            System.out.print("Nombre: " + pacientes[i].getNombre());
            System.out.print("Edad: " + pacientes[i].getEdad());
            System.out.print("Sexo: " + pacientes[i].getSexo());
            System.out.print("Peso: " + pacientes[i].getPeso());

        }
    }

    public static String diagnostico(int i) {

        double imc = calcularIMC(i);

        if (imc < 18.5){
            
            return "Peso bajo";
        }

        else if (imc < 25.0) {
            
            return "Peso normal";
        }

        else{

            return "Sobrepeso";
        } 
    }

     public static void mostrarDiagnostico() {

        if (totalRegistrados == 0) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        for (int i = 0; i < totalRegistrados; i++) {
            System.out.printf("%nPaciente: %s  →  %s%n",
                pacientes[i].getNombre(),
                diagnostico(i));
        }
    }
}
