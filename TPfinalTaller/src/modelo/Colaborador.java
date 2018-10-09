package modelo;

import java.io.Serializable;

public class Colaborador extends Usuario implements Serializable
{
    public Colaborador()
    {
        super();
    }

    public Colaborador(String nombre_apellido, String email, String telefono, String nombre_de_usuario,
                       String contraseña)
    {
        // TODO Implement this method
        super(nombre_apellido, email, telefono, nombre_de_usuario, contraseña);
    }
}
