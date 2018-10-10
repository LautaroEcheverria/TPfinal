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
    private HashMap<String,GrupoDeClientes> grupoClientes;
    private HashMap<String,Servicio> servicios;
    private HashMap<String,Cliente> clientes;
    private ArrayList<Tarea> tareas;
    private Serializador sDB = new Serializador();
    
    public BaseDatos()
    {
        usuarios = new HashMap<String,Usuario>();
        grupoClientes = new HashMap<String,GrupoDeClientes>();
        servicios = new HashMap<String,Servicio>();
        clientes = new HashMap<String,Cliente>();
        tareas = new ArrayList<Tarea>();
    }
    
    public void agregaTarea(Tarea nueva)
    {
        this.tareas.add(nueva);
        this.guardarBase();
    }
    
    public void elimTarea(Tarea elim)
    {
        this.tareas.remove(elim);
        this.guardarBase();
    }
    
    public void agregaServicio(Servicio nuevo)
    {
        this.servicios.put(nuevo.getDescripcion(), nuevo);
        this.guardarBase();
    }
    
    public void elimServicio(Servicio elim)
    {
        this.servicios.remove(elim.getDescripcion());
        this.guardarBase();
    }
    
    public void agregaCliente(Cliente nuevo)
    {
        this.clientes.put(nuevo.getNombre_apellido(), nuevo);
        this.guardarBase();
    }
    
    public void elimCliente(Cliente elim)
    {
        this.clientes.remove(elim.getNombre_apellido());
        this.guardarBase();
    }
    
    public void agregaGrupoClientes(GrupoDeClientes nuevo)
    {
        this.grupoClientes.put(nuevo.getNombre_grupo(), nuevo);
        this.guardarBase();
    }
    
    public void agregaUsuario(Usuario usuario) 
    {
        this.usuarios.put(usuario.getNombre_de_usuario(),usuario);
        this.guardarBase();
    }
    
    public Usuario compruebaUsuario(String usuario,String contrasenia)
    {
        Usuario resp=null;
        if (this.usuarios.containsKey(usuario))
        {
            Usuario aux = this.usuarios.get(usuario);
            if (aux.getContrasenia().equals(contrasenia))   
                resp = aux;
        }
        return resp;
    }
    
    public ArrayList<Tarea> tareasUsuario(Usuario usuario)
    {
        ArrayList<Tarea> aux;
        if (usuario.getPerfil().equals("Administrador"))
        {
            aux=this.tareas;
        }
        else
        {
            aux = new ArrayList<Tarea>();
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
    
    public ArrayList<Cliente> arrayClientes()
    {
        ArrayList<Cliente> aux=new ArrayList<Cliente>();
        Iterator<Cliente> it = this.clientes.values().iterator();
        while (it.hasNext())
        {
            aux.add(it.next());
        }
        return aux;
    }
    
    public ArrayList<Servicio> arrayServicios()
    {
        ArrayList<Servicio> aux=new ArrayList<Servicio>();
        Iterator<Servicio> it = this.servicios.values().iterator();
        while (it.hasNext())
        {
            aux.add(it.next());
        }
        return aux;
    }
    
    public void guardarBase() 
    {
        try 
        {
            this.sDB.guardarBaseDeDatos(this);
        } catch (IOException e) 
        {
            System.out.println("No se guardo");
        }
        this.updateObservers();
    }

    private void updateObservers()
    {
        this.setChanged();
        this.notifyObservers();
    }
    
    

    public void setServicios(HashMap<String, Servicio> servicios)
    {
        this.servicios = servicios;
    }

    public HashMap<String, Servicio> getServicios()
    {
        return servicios;
    }

    public void setClientes(HashMap<String, Cliente> clientes)
    {
        this.clientes = clientes;
    }

    public HashMap<String, Cliente> getClientes()
    {
        return clientes;
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

