package modelo;

import java.io.Serializable;

public abstract class Estado implements Serializable
{
    private String estado;
                   
    public Estado()
    {
        super();
    }
                        
    public Estado(String estado)
    {
        super();
        this.estado = estado;
    }
    
    abstract public void abiertaPausa();
    abstract public void abiertaCerrada();
    abstract public void pausaAbierta();
    abstract public void pausaCerrada();
    abstract public boolean cambiarEstado();
    abstract public String cambioPosible();


    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getEstado()
    {
        return estado;
    }
}

