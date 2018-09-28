package modelo;

public class Usuario extends Persona
{
    private String nombre_de_usuario;
    private String contraseña;
    private String perfil;
    
    
    public Usuario()
    {
        super();
    }

    public Usuario(String nombre_de_usuario, String contraseña)
    {
        super();
        this.nombre_de_usuario = nombre_de_usuario;
        this.contraseña = contraseña;
    }

    public void setNombre_de_usuario(String nombre_de_usuario)
    {
        this.nombre_de_usuario = nombre_de_usuario;
    }

    public String getNombre_de_usuario()
    {
        return nombre_de_usuario;
    }

    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }

    public String getContraseña()
    {
        return contraseña;
    }
}

