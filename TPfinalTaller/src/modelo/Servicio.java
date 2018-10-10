package modelo;

import java.io.Serializable;

public class Servicio implements Serializable
{
    private String descripcion;
    private String tipo;
    private double costo;
    
    public Servicio()
    {
        super();
    }


    @Override
    public String toString()
    {
        // TODO Implement this method
        return this.descripcion+" Tipo: "+this.tipo+" Costo: "+this.costo;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setCosto(double costo)
    {
        this.costo = costo;
    }

    public double getCosto()
    {
        return costo;
    }
}
