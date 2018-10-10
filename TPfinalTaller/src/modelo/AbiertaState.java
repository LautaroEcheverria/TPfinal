package modelo;

import java.io.Serializable;

public class AbiertaState extends Estado implements Serializable
{
    private Tarea tarea;
    
    public AbiertaState()
    {
        
    }
    
    public AbiertaState(Tarea tarea)
    {
        super("Abierta");
        this.tarea = tarea;
    }

    public boolean cambiarEstado()
    {
        return true;
    }
    @Override
    public void abiertaPausa()
    {
        // TODO Implement this method
        tarea.setEstado_actual(new PausaState(this.tarea));
    }

    @Override
    public void abiertaCerrada()
    {
        // TODO Implement this method
        tarea.setEstado_actual(new CerradaState(this.tarea));
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
    public String cambioPosible()
    {
        // TODO Implement this method
        return "Pausa o Cerrada";
    }
}
