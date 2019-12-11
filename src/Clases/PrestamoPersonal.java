
package Clases;

public class PrestamoPersonal {
    
    private Cliente obj = new Cliente();
    
    //Prestamo Personal///////////////////////////////////////////////////////////////
    //aquí jalamos al cliente por su codigo 
    private String CodigoCliente;
    private String CodigoEmpleado;
    private int nroCuotas;//estará en un radiobuton
    private int MSolicitarP;//Hasta 50000; 6 y 60 meses de plazo de pago; 60 dias para pagar tu primera cuota   
    private int IngresarCuenta;//ingresa tu numero de tarjeta;
    private double sueldo;

    public PrestamoPersonal() {
    }

    public PrestamoPersonal(String CodigoCliente, String CodigoEmpleado, int nroCuotas, int MSolicitarP, int IngresarCuenta, double sueldo) {
        this.CodigoCliente = CodigoCliente;
        this.CodigoEmpleado = CodigoEmpleado;
        this.nroCuotas = nroCuotas;
        this.MSolicitarP = MSolicitarP;
        this.IngresarCuenta = IngresarCuenta;
        this.sueldo = sueldo;
    }
    
    
    
    //Prestamos personal (pp)
     
    public double PPMOntoMensualAPagar(){
        return MSolicitarP/nroCuotas;
    }
    
    
    //Get and Set

    public Cliente getObj() {
        return obj;
    }

    public void setObj(Cliente obj) {
        this.obj = obj;
    }

    public int getNroCuotas() {
        return nroCuotas;
    }

    public void setNroCuotas(int nroCuotas) {
        this.nroCuotas = nroCuotas;
    }

    public int getMSolicitarP() {
        return MSolicitarP;
    }

    public void setMSolicitarP(int MSolicitarP) {
        this.MSolicitarP = MSolicitarP;
    }    

    public int getIngresarCuenta() {
        return IngresarCuenta;
    }

    public void setIngresarCuenta(int IngresarCuenta) {
        this.IngresarCuenta = IngresarCuenta;
    }

    public String getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(String CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    public String getCodigoEmpleado() {
        return CodigoEmpleado;
    }

    public void setCodigoEmpleado(String CodigoEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    


    
}
