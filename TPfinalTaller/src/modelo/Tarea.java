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
    
    public void setColaborador(Usuario colaborador)
    {
        this.colaborador = colaborador;
    }

    public Usuario getColaborador()
    {
        return colaborador;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setServicio(Servicio servicio)
    {
        this.servicio = servicio;
    }

    public Servicio getServicio()
    {
        return servicio;
    }

    public void setFecha_inicio(GregorianCalendar fecha_inicio)
    {
        this.fecha_inicio = fecha_inicio;
    }

    public GregorianCalendar getFecha_inicio()
    {
        return fecha_inicio;
    }

    public void setFecha_cierre(GregorianCalendar fecha_cierre)
    {
        this.fecha_cierre = fecha_cierre;
    }

    public GregorianCalendar getFecha_cierre()
    {
        return fecha_cierre;
    }

    public void setEstado_actual(Estado estado_actual)
    {
        this.estado_actual = estado_actual;
    }

    public Estado getEstado_actual()
    {
        return estado_actual;
    }

    public void setCosto_total(double costo_total)
    {
        this.costo_total = costo_total;
    }

    public double getCosto_total()
    {
        return costo_total;
    }
}
