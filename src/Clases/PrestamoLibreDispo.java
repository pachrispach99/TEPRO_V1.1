
package Clases;

public class PrestamoLibreDispo {
    
    private Cliente obj = new Cliente();
    
    //Prestamo libre Disponibilidad(ld)
    private int nrocuotasLD;
    private int MsolicitarLD;
    private int cuentaAhorrosLD;//mostrará las opciones
    private int IngresarCuentaLD;//ingresa tu ceunta de ahorros;
private int sueldo;
    public PrestamoLibreDispo() {
    }

    public PrestamoLibreDispo(int nrocuotasLD, int MsolicitarLD, int cuentaAhorrosLD, int IngresarCuentaLD) {
        this.nrocuotasLD = nrocuotasLD;
        this.MsolicitarLD = MsolicitarLD;
        this.cuentaAhorrosLD = cuentaAhorrosLD;
        this.IngresarCuentaLD = IngresarCuentaLD;
    }
    
    
    public Cliente getObj() {
        return obj;
    }

    public void setObj(Cliente obj) {
        this.obj = obj;
    }

    public int getNrocuotasLD() {
        return nrocuotasLD;
    }

    public void setNrocuotasLD(int nrocuotasLD) {
        this.nrocuotasLD = nrocuotasLD;
    }

    public int getMsolicitarLD() {
        return MsolicitarLD;
    }

    public void setMsolicitarLD(int MsolicitarLD) {
        this.MsolicitarLD = MsolicitarLD;
    }

    public int getCuentaAhorrosLD() {
        return cuentaAhorrosLD;
    }

    public void setCuentaAhorrosLD(int cuentaAhorrosLD) {
        this.cuentaAhorrosLD = cuentaAhorrosLD;
    }

    public int getIngresarCuentaLD() {
        return IngresarCuentaLD;
    }

    public void setIngresarCuentaLD(int IngresarCuentaLD) {
        this.IngresarCuentaLD = IngresarCuentaLD;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
    
}
