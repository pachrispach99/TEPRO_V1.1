package Clases;

public class Cliente {
    Empleado objempleado= new Empleado();
    
    /*
    extraemos el nombre y codigo del empleado que
    le atendió al cliente y le registró
    */
    
    //DATOS PARA REGISTRAR AL CLIENTE QUE ES NECESARIO PARA EVALUARLO
    private String codigo;
    private String nombres;
    private String apellidomater;
    private String apellidopater;            
    private int edad;
    private String sexo;//Femenino , Masculino, Pacheco
    private String Nacionalidad;
    private String Direccion;
    private String Profesion;
    private int Telefono;
    private int Celular;
    private String EstadoC;// Soltero casado viudo divorciado
    private String Email;
    private String TrabajoActual;
    
   //akjsdhkajshdsajkdhaskjdhaskjdhas
    
    private double IngresoMe;// SUELDO cliente
    
    
 
    //Situacion de vivienda
    private boolean Propagada;
    private boolean Propagandola;
    private boolean Proalquilada;
    private boolean Profamiliar;
    //Grado de Instruccion
    private boolean Primaria;
    private boolean Tecnica;
    private boolean Secundaria;
    private boolean Posgrado;
    private boolean Universitaria;
    
    private String TipoPrestamos; //Personal, Hipotecario, Libre Disponibilidad, Adelanto de Sueldo
   
    public Cliente(){
        
    }
            
    public Cliente(String codigo, String nombres, String apellidomater, String apellidopater, int edad, String sexo, String Nacionalidad, String Direccion, String Profesion, int Telefono, int Celular, String EstadoC, String Email, String TrabajoActual, double IngresoMe, boolean Propagada, boolean Propagandola, boolean Proalquilada, boolean Profamiliar, boolean Primaria, boolean Tecnica, boolean Secundaria, boolean Posgrado, boolean Universitaria, String TipoPrestamos) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidomater = apellidomater;
        this.apellidopater = apellidopater;
        this.edad = edad;
        this.sexo = sexo;
        this.Nacionalidad = Nacionalidad;
        this.Direccion = Direccion;
        this.Profesion = Profesion;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.EstadoC = EstadoC;
        this.Email = Email;
        this.TrabajoActual = TrabajoActual;
        this.IngresoMe = IngresoMe;
        this.Propagada = Propagada;
        this.Propagandola = Propagandola;
        this.Proalquilada = Proalquilada;
        this.Profamiliar = Profamiliar;
        this.Primaria = Primaria;
        this.Tecnica = Tecnica;
        this.Secundaria = Secundaria;
        this.Posgrado = Posgrado;
        this.Universitaria = Universitaria;
        this.TipoPrestamos = TipoPrestamos;
    }
    //mostrar situacion vivienda
    public String SVivienda(){
        if(Propagada==true)return "Propagada";
        else if(Propagandola==true)return "ProPagandola";
        else if(Proalquilada==true)return "ProAlquilada";
        else if(Profamiliar==true)return "ProFamiliar";
        else return "No ha selecionado esta Opcion";

    }
     //mostrar grado de institucion
    public String GIntitucion(){
        if(Primaria==true)return "Primaria";
        else if(Secundaria==true)return "Secundaria";
        else if(Tecnica==true)return "Tecnica";
        else if(Posgrado==true)return "Posgrado";
        else if(Universitaria==true)return "Universitario";
        else return "No ha selecionado esta Opcion";
    }
            
            
    
   
    
    public Empleado getObjempleado() {
        return objempleado;
    }

    public void setObjempleado(Empleado objempleado) {
        this.objempleado = objempleado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidomater() {
        return apellidomater;
    }

    public void setApellidomater(String apellidomater) {
        this.apellidomater = apellidomater;
    }

    public String getApellidopater() {
        return apellidopater;
    }

    public void setApellidopater(String apellidopater) {
        this.apellidopater = apellidopater;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getCelular() {
        return Celular;
    }

    public void setCelular(int Celular) {
        this.Celular = Celular;
    }

    public String getEstadoC() {
        return EstadoC;
    }

    public void setEstadoC(String EstadoC) {
        this.EstadoC = EstadoC;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTrabajoActual() {
        return TrabajoActual;
    }

    public void setTrabajoActual(String TrabajoActual) {
        this.TrabajoActual = TrabajoActual;
    }

    public double getIngresoMe() {
        return IngresoMe;
    }

    public void setIngresoMe(double IngresoMe) {
        this.IngresoMe = IngresoMe;
    }

    public boolean isPropagada() {
        return Propagada;
    }

    public void setPropagada(boolean Propagada) {
        this.Propagada = Propagada;
    }

    public boolean isPropagandola() {
        return Propagandola;
    }

    public void setPropagandola(boolean Propagandola) {
        this.Propagandola = Propagandola;
    }

    public boolean isProalquilada() {
        return Proalquilada;
    }

    public void setProalquilada(boolean Proalquilada) {
        this.Proalquilada = Proalquilada;
    }

    public boolean isProfamiliar() {
        return Profamiliar;
    }

    public void setProfamiliar(boolean Profamiliar) {
        this.Profamiliar = Profamiliar;
    }

    public boolean isPrimaria() {
        return Primaria;
    }

    public void setPrimaria(boolean Primaria) {
        this.Primaria = Primaria;
    }

    public boolean isTecnica() {
        return Tecnica;
    }

    public void setTecnica(boolean Tecnica) {
        this.Tecnica = Tecnica;
    }

    public boolean isSecundaria() {
        return Secundaria;
    }

    public void setSecundaria(boolean Secundaria) {
        this.Secundaria = Secundaria;
    }

    public boolean isPosgrado() {
        return Posgrado;
    }

    public void setPosgrado(boolean Posgrado) {
        this.Posgrado = Posgrado;
    }

    public boolean isUniversitaria() {
        return Universitaria;
    }

    public void setUniversitaria(boolean Universitaria) {
        this.Universitaria = Universitaria;
    }

    public String getTipoPrestamos() {
        return TipoPrestamos;
    }

    public void setTipoPrestamos(String TipoPrestamos) {
        this.TipoPrestamos = TipoPrestamos;
    }

  

    
    
    
    

    
    
    
}
