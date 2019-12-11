
package Clases;

public class PrestamoHipotecario {
    
    private Cliente obj = new Cliente();
    
   
    private int nroCuotasph;//estará en un radiobuton
    private int MSolicitarPh;//Hasta 50000; 6 y 60 meses de plazo de pago; 60 dias para pagar tu primera cuota
    private int cuentaAhorrosph;//mostrará las opciones
    private int IngresarCuentaph;//ingresa tu ceunta de ahorros;

    public PrestamoHipotecario(int nroCuotasph, int MSolicitarPh, int cuentaAhorrosph, int IngresarCuentaph) {
        this.nroCuotasph = nroCuotasph;
        this.MSolicitarPh = MSolicitarPh;
        this.cuentaAhorrosph = cuentaAhorrosph;
        this.IngresarCuentaph = IngresarCuentaph;
    }

    public PrestamoHipotecario() {
    }

    public Cliente getObj() {
        return obj;
    }

    public void setObj(Cliente obj) {
        this.obj = obj;
    }

    public int getNroCuotasph() {
        return nroCuotasph;
    }

    public void setNroCuotasph(int nroCuotasph) {
        this.nroCuotasph = nroCuotasph;
    }

    public int getMSolicitarPh() {
        return MSolicitarPh;
    }

    public void setMSolicitarPh(int MSolicitarPh) {
        this.MSolicitarPh = MSolicitarPh;
    }

    public int getCuentaAhorrosph() {
        return cuentaAhorrosph;
    }

    public void setCuentaAhorrosph(int cuentaAhorrosph) {
        this.cuentaAhorrosph = cuentaAhorrosph;
    }

    public int getIngresarCuentaph() {
        return IngresarCuentaph;
    }

    public void setIngresarCuentaph(int IngresarCuentaph) {
        this.IngresarCuentaph = IngresarCuentaph;
    }
    
    
    
    
}
