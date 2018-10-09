package modelo;

import java.io.Serializable;

public class Usuario extends Persona implements Serializable
{
    private String nombre_de_usuario;
    private String contraseña;
    private String perfil;

    public Usuario()
    {
        super();
    }

    public Usuario(String nombre_apellido, String email, String telefono,String nombre_de_usuario, String contraseña)
    {
        // TODO Implement this method
        super(nombre_apellido, email, telefono);
        this.nombre_de_usuario = nombre_de_usuario;
        this.contraseña = contraseña;
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

    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }

    public String getContraseña()
    {
        return contraseña;
    }
}

