package modelo;

import java.io.Serializable;

public class GrupoDeClientes implements Serializable
{
    private String nombre_grupo;
    
    public GrupoDeClientes()
    {
        super();
    }

    public void setNombre_grupo(String nombre_grupo)
    {
        this.nombre_grupo = nombre_grupo;
    }

    public String getNombre_grupo()
    {
        return nombre_grupo;
    }

    @Override
    public String toString()
    {
        // TODO Implement this method
        return this.getNombre_grupo();
    }
}
