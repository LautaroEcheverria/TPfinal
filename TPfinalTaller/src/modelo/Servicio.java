package modelo;

import java.io.Serializable;

public class Servicio implements Serializable
{
    private String descripci�n;
    private String tipo;
    private double costo;
    
    public Servicio()
    {
        super();
    }

    public void setDescripci�n(String descripci�n)
    {
        this.descripci�n = descripci�n;
    }

    public String getDescripci�n()
    {
        return descripci�n;
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
