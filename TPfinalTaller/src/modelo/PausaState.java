package modelo;

import java.io.Serializable;

public class PausaState extends Estado implements Serializable
{
    private Tarea tarea;
    
    public PausaState()
    {
        super();
    }
    
    public PausaState(Tarea tarea)
    {
        super("Pausa");
        this.tarea = tarea;
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
        tarea.setEstado_actual(new AbiertaState(this.tarea));
    }

    @Override
    public void pausaCerrada()
    {
        // TODO Implement this method
        tarea.setEstado_actual(new CerradaState(this.tarea));
    }

    @Override
    public boolean cambiarEstado()
    {
        // TODO Implement this method
        return true;  
    }

    @Override
    public String cambioPosible()
    {
        // TODO Implement this method
        return "Abierta o Cerrada";  
    }
}
