package modelo;

import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;

public class BaseDatos extends Observable implements Serializable
{
    private HashMap<String,Usuario> usuarios;
    private ArrayList<Tarea> tareas;
    private Serializador sDB = new Serializador();
    private HashMap<String,GrupoDeClientes> grupoClientes;
    
    public BaseDatos()
    {
        usuarios = new HashMap<String,Usuario>();
        tareas = new ArrayList<Tarea>();
        grupoClientes = new HashMap<String,GrupoDeClientes>();
    }
    
    public void agregaGrupoClientes(GrupoDeClientes nuevo)
    {
        this.grupoClientes.put(nuevo.getNombre_grupo(), nuevo);
        this.guardarBase();
    }
    
    public Usuario compruebaUsuario(String usuario,String contrasenia)
    {
        Usuario resp=null;
        if (this.usuarios.containsKey(usuario))
        {
            Usuario aux = this.usuarios.get(usuario);
            if (aux.getContraseña().equals(contrasenia))   
                resp = aux;
        }
        return resp;
    }
    
    public ArrayList<Tarea> tareasUsuario(Usuario usuario)
    {
        ArrayList<Tarea> aux = null;
        if (usuario.getPerfil().equals("Administrador"))
        {
            aux=this.tareas;
        }
        else
        {
            Iterator<Tarea> it = this.tareas.iterator();
            while (it.hasNext())
            {
                Tarea tareaAux = it.next();
                if (tareaAux.getColaborador() == usuario)
                    aux.add(tareaAux);
            }
        }
        return aux;
    }
    
    public void agregaUsuario(Usuario usuario) 
    {
        this.usuarios.put(usuario.getNombre_de_usuario(),usuario);
    }
    
    public void guardarBase() 
    {
        try 
        {
            this.sDB.guardarBaseDeDatos(this);
        } catch (IOException e) 
        {
        }
        this.updateObservers();
    }

    public void updateObservers()
    {
        this.setChanged();
        this.notifyObservers();
    }

    public void setUsuarios(HashMap<String, Usuario> usuarios)
    {
        this.usuarios = usuarios;
    }

    public HashMap<String, Usuario> getUsuarios()
    {
        return usuarios;
    }

    public void setTareas(ArrayList<Tarea> tareas)
    {
        this.tareas = tareas;
    }

    public ArrayList<Tarea> getTareas()
    {
        return tareas;
    }

    public void setSDB(Serializador sDB)
    {
        this.sDB = sDB;
    }

    public Serializador getSDB()
    {
        return sDB;
    }
    
    public void setGrupoClientes(HashMap<String, GrupoDeClientes> grupoClientes)
    {
        this.grupoClientes = grupoClientes;
    }

    public HashMap<String, GrupoDeClientes> getGrupoClientes()
    {
        return grupoClientes;
    }
}

