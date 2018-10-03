package modelo;

import java.io.Serializable;

import java.util.GregorianCalendar;

public class Tarea implements Serializable
{
    private Usuario colaborador;
    private Cliente cliente;
    private Servicio servicio;
    private GregorianCalendar fecha_inicio;
    private GregorianCalendar fecha_cierre;
    private Estado estado_actual;
    private double costo_total;
    
    
    
    public Tarea()
    {
        super();
    }
}