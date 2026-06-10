public class Paciente {

    private String nombre;
    private int edad;
    private String sexo;
    private int peso;
    private int altura;

    public Paciente(){

        setNombre("");
        setEdad(0);
        setSexo("");
        setPeso(0);
        setAltura(0);

    }

    public Paciente(String nombre, int edad, String sexo, int peso, int altura){
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
        setPeso(peso);
        setAltura(altura);
    }

    public String getNombre(){
        return nombre;
    } 
    
    public int getEdad(){
        return edad;
    }

    public String getSexo(){
        return sexo;
    }

    public int getPeso(){
        return peso;
    }

    public int getAltura(){
        return altura;
    }

    public void setNombre(String nombre){

        this.nombre = nombre;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public void setPeso(int peso){
        this.peso = peso; 
    }

    public void setAltura(int altura){
        this.altura = altura;
    }
}
