package modelo;

import java.io.Serializable;

public class Usuario extends Persona implements Serializable
{
    private String nombre_de_usuario;
    private String contrasenia;
    private String perfil;

    public Usuario()
    {
        super();
    }

    @Override
    public String toString()
    {
        // TODO Implement this method
        return this.nombre_de_usuario+" Perfil: "+this.perfil;
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

    public void setContrasenia(String contrasenia)
    {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia()
    {
        return contrasenia;
    }
}

