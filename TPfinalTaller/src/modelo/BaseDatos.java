package modelo;

import java.io.Serializable;

import java.util.ArrayList;

public class BaseDatos implements Serializable
{
    private ArrayList<Usuario> usuarios;
    private ArrayList<Tarea> tareas;
    
    public BaseDatos()
    {
        usuarios = new ArrayList<Usuario>();
        tareas = new ArrayList<Tarea>();
    }
}
