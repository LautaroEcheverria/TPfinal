package modelo;

import java.io.Serializable;

public class CerradaState extends Estado implements Serializable
{
    private Tarea tarea;
    
    public CerradaState()
    {
        
    }
    
    public CerradaState(Tarea tarea)
    {
        super("Cerrada");
        this.tarea = tarea;
        this.tarea.tareaCerrada();
    }

    @Override
    public void abiertaPausa()
    {
        // TODO Implement this method
    }

    @Override
    public void abiertaCerrada()
    {
        // TODO Implement this method
    }

    @Override
    public void pausaAbierta()
    {
        // TODO Implement this method
    }

    @Override
    public void pausaCerrada()
    {
        // TODO Implement this method
    }

    @Override
    public boolean cambiarEstado()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public String cambioPosible()
    {
        // TODO Implement this method
        return null;
    }
}
