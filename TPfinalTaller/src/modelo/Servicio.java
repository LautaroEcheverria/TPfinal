package modelo;

import java.io.Serializable;

public class Servicio implements Serializable
{
    private String descripción;
    private String tipo;
    private double costo;
    
    public Servicio()
    {
        super();
    }

    public void setDescripción(String descripción)
    {
        this.descripción = descripción;
    }

    public String getDescripción()
    {
        return descripción;
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
