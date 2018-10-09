package modelo;

import java.io.Serializable;

public class Usuario extends Persona implements Serializable
{
    private String nombre_de_usuario;
    private String contrase�a;
    private String perfil;

    public Usuario()
    {
        super();
    }

    public Usuario(String nombre_apellido, String email, String telefono,String nombre_de_usuario, String contrase�a)
    {
        // TODO Implement this method
        super(nombre_apellido, email, telefono);
        this.nombre_de_usuario = nombre_de_usuario;
        this.contrase�a = contrase�a;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
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

