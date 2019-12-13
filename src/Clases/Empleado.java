
package Clases;

public class Empleado {
    
  private String codigo; 
    private String nombre;
    private String apellido;
    private int dni;
    private boolean sexo1;
    private boolean sexo2;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(String codigo, String nombre, String apellido, int dni, boolean sexo1, boolean sexo2, double sueldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo1 = sexo1;
        this.sexo2 = sexo2;
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isSexo1() {
        return sexo1;
    }

    public void setSexo1(boolean sexo1) {
        this.sexo1 = sexo1;
    }

    public boolean isSexo2() {
        return sexo2;
    }

    public void setSexo2(boolean sexo2) {
        this.sexo2 = sexo2;
    }

   
    
    public String Sexo()
 {
     if(sexo1==true)
         return "femenino";
   else  if(sexo2==true)
         return "masculino";
   else return "-";
 }

    public void setcodigo(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getcodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
    

    