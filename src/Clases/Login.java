
package Clases;

public class Login {
    private String usuario;
    private String Contraseña;

    public Login() {
    }

    public Login(String usuario, String Contraseña) {
        this.usuario = usuario;
        this.Contraseña = Contraseña;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
