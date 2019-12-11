
package Clases;

public class PrestamoAdelantoSueldo {
    
    private Cliente obj= new Cliente();
    
    //Adelanto de Sueldo////////////////////////////////////////////////////
    private String Cuenta;// Tiene una cuenta con el banco Sctiabank? Si / No
    private int Nabonos;// Haber recibido mas de 3 abonos en tu cuenta;    
    //Sueldo del cliente , ya esta en la clase cliente.        
    private int Numerotarjeta;
    private int MSolicitarA;//Entre 100 a 2.500(El maximo es 30% del sueldo del cliente)Crear restriccion;

    public PrestamoAdelantoSueldo() {
    }

    public PrestamoAdelantoSueldo(String Cuenta, int Nabonos, int Numerotarjeta, int MSolicitarA) {
        this.Cuenta = Cuenta;
        this.Nabonos = Nabonos;
        this.Numerotarjeta = Numerotarjeta;
        this.MSolicitarA = MSolicitarA;
    }

    public Cliente getObj() {
        return obj;
    }

    public void setObj(Cliente obj) {
        this.obj = obj;
    }

    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    public int getNabonos() {
        return Nabonos;
    }

    public void setNabonos(int Nabonos) {
        this.Nabonos = Nabonos;
    }

    public int getNumerotarjeta() {
        return Numerotarjeta;
    }

    public void setNumerotarjeta(int Numerotarjeta) {
        this.Numerotarjeta = Numerotarjeta;
    }

    public int getMSolicitarA() {
        return MSolicitarA;
    }

    public void setMSolicitarA(int MSolicitarA) {
        this.MSolicitarA = MSolicitarA;
    }
    
     //Funciones---------------------------------------------------------------------------------
    public double AdelantoSueldo()
    {
        if(Nabonos>=3)
        {
            if(obj.getIngresoMe() > 400) 
            {
                if(MSolicitarA>100 && MSolicitarA<0.3*obj.getIngresoMe())
                {
                    return MSolicitarA;
                }
                else
                    return 0;
            }     
            else
            {
                return 0;
            }            
        }
        else 
            return 0;
    }
    
    public double Comisionfija()
    {
        if(Nabonos>=3)
        {
            if(obj.getIngresoMe() > 400) 
            {
                if(MSolicitarA>100 && MSolicitarA<0.3*obj.getIngresoMe())
                {
                    return MSolicitarA*0.04;
                }
                else
                    return 0;
            }     
            else
            {
                return 0;
            }            
        }
        else 
            return 0;
    }
    
    public double Descuentosueldo()//Descuento automatico al sueldo del solicitante
    {
        return obj.getIngresoMe()-Comisionfija()+AdelantoSueldo();
        
    }
    
}
