package modelo;

public class Usuario extends Persona
{
    private String nombre_de_usuario;
    private String contrase�a;
    private String perfil;
    
    
    public Usuario()
    {
        super();
    }

    public Usuario(String nombre_de_usuario, String contrase�a)
    {
        super();
        this.nombre_de_usuario = nombre_de_usuario;
        this.contrase�a = contrase�a;
    }

    public void setNombre_de_usuario(String nombre_de_usuario)
    {
        this.nombre_de_usuario = nombre_de_usuario;
    }

    public String getNombre_de_usuario()
    {
        return nombre_de_usuario;
    }

    public void setContrase�a(String contrase�a)
    {
        this.contrase�a = contrase�a;
    }

    public String getContrase�a()
    {
        return contrase�a;
    }
}

