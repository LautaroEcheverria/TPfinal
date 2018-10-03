package modelo;

import java.io.Serializable;

public class Persona implements Serializable
{
    private String nombre_apellido;
    private String email;
    private String telefono;
    
    
    public Persona()
    {
        super();
    }

    public Persona(String nombre_apellido, String email, String telefono)
    {
        this.nombre_apellido = nombre_apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public void setNombre_apellido(String nombre_apellido)
    {
        this.nombre_apellido = nombre_apellido;
    }

    public String getNombre_apellido()
    {
        return nombre_apellido;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getTelefono()
    {
        return telefono;
    }

}
