package modelo;

import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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
    
    public void cambioCont(Usuario actual,String contra)
    {
        Usuario aux = this.usuarios.get(actual.getNombre_de_usuario());
        aux.setContrasenia(contra);
        this.guardarBase();
    }
    
    public String tareasCliente(Cliente cliente, GregorianCalendar inicio, GregorianCalendar fin)
    {
        String retorno="";    
        Iterator<Tarea> it = this.tareas.iterator();
        retorno+= cliente.toString()+"\n";
        retorno+= "Tarea de servicio\tTotal de horas\tImporte\n";
        double costoTotal=0;;
        while (it.hasNext())
        {
            Tarea tarea = it.next();
            if (tarea.getCliente() == cliente && tarea.getEstado_actual().getEstado().equalsIgnoreCase("CERRADA"))
            {    
                if (!((tarea.getFecha_cierre()!= null && tarea.getFecha_cierre().before(inicio)) || 
                     tarea.getFecha_inicio().after(fin)))
                {
                    double costoTarea = tarea.getCosto_total();
                    retorno+= tarea.getServicio().getDescripcion()+" "+
                              tarea.cantidadHoras()+" "+
                              costoTarea+"\n";
                    costoTotal += costoTarea;
                }
            }
        }
        retorno += "IMPORTE TOTAL: $"+costoTotal;
        return retorno;
    }
    
    public String tareasColaborador(Usuario usuario, GregorianCalendar inicio, GregorianCalendar fin)
    {
        String retorno="";    
        Iterator<Cliente> it = this.clientes.values().iterator();
        retorno+= usuario.toString()+"\n";
        retorno+= "Cliente\tTarea de servicio\tTotal de horas\n";
        while (it.hasNext())
        {
            Cliente cliente = it.next();
            retorno += cliente.getNombre_apellido()+"\n";
            Iterator<Tarea> it2 = this.tareas.iterator();
            double totalHoras=0;
            while (it2.hasNext())
            {
                Tarea tarea = it2.next();
                if (tarea.getCliente() == cliente && tarea.getColaborador() == usuario)
                    if (!((tarea.getFecha_cierre()!= null && tarea.getFecha_cierre().before(inicio)) || 
                            tarea.getFecha_inicio().after(fin)))
                    {
                        double horasTarea = tarea.cantidadHoras();
                        retorno+= tarea.getServicio().getDescripcion()+" "+
                                  horasTarea+"\n";
                        totalHoras += horasTarea;
                    }
            }  
            retorno += "\tTOTAL HS: "+totalHoras+"\n";
        }
        return retorno;
    }
    
    public String tareasEstado(Usuario usuario)
    {
        String retorno="";    
        Iterator<Tarea> it = this.tareas.iterator();
        retorno+= "Colaborador Cliente Tareas de Servicio Inicio Estado Horas Acumuladas\n";
        while (it.hasNext())
        {
            Tarea tarea = it.next();
            if (usuario == null || (usuario != null && usuario == tarea.getColaborador()))
            {
                retorno+= tarea.getColaborador().getNombre_apellido()+" "+
                          tarea.getCliente().getNombre_apellido()+" "+
                          tarea.getServicio().getDescripcion()+" "+
                          tarea.getFecha_inicio().get(GregorianCalendar.DATE)+"/"+
                          tarea.getFecha_inicio().get(GregorianCalendar.MONTH)+"/"+
                          tarea.getFecha_inicio().get(GregorianCalendar.YEAR)+"/"+
                          tarea.getFecha_inicio().get(GregorianCalendar.MONTH)+" "+
                          tarea.getFecha_inicio().get(GregorianCalendar.HOUR)+":"+
                          tarea.getFecha_inicio().get(GregorianCalendar.MINUTE)+" "+
                          tarea.getEstado_actual().getEstado()+" "+
                          tarea.cantidadHoras()+"\n";
            }
        }
        return retorno;
    }
    
    public String tareasUsuario(Usuario usuario, GregorianCalendar inicio, GregorianCalendar fin, String estado)
    {
        String retorno="";    
        Iterator<Tarea> it = this.tareas.iterator();
        retorno+= usuario.toString()+"\n";
        retorno+= "Cliente\tTarea de servicio\tInicio\tEstado\tHoras Acumuladas\n";
        double totalHoras=0;
        while (it.hasNext())
        {
            Tarea tarea = it.next();
            if (tarea.getColaborador() == usuario && 
                (estado.equalsIgnoreCase("TODOS") || estado.equalsIgnoreCase(tarea.getEstado_actual().getEstado())))
                if (!((tarea.getFecha_cierre()!= null && tarea.getFecha_cierre().before(inicio)) || 
                        tarea.getFecha_inicio().after(fin)))
                {
                    retorno+= tarea.getCliente().getNombre_apellido()+" "+
                              tarea.getServicio().getDescripcion()+" "+
                              tarea.getFecha_inicio().get(GregorianCalendar.DATE)+"/"+
                              tarea.getFecha_inicio().get(GregorianCalendar.MONTH)+"/"+
                              tarea.getFecha_inicio().get(GregorianCalendar.YEAR)+"/"+
                              tarea.getFecha_inicio().get(GregorianCalendar.MONTH)+" "+
                              tarea.getFecha_inicio().get(GregorianCalendar.HOUR)+":"+
                              tarea.getFecha_inicio().get(GregorianCalendar.MINUTE)+" "+
                              tarea.getEstado_actual().getEstado()+" "+
                              tarea.cantidadHoras()+"\n";
                }
        }  
        return retorno;
    }
    
    public void agregaTarea(Tarea nueva)
    {
        Iterator<Tarea> it = this.tareas.iterator();
        boolean ningunaAbierta = true;
        while (it.hasNext() && ningunaAbierta)
        {
            Tarea tarea = it.next();
            if (tarea.getColaborador() == nueva.getColaborador())
                if (tarea.getEstado_actual().getEstado().equalsIgnoreCase("ABIERTA"))
                    ningunaAbierta = false;
        }
        if (ningunaAbierta)
        {
            this.tareas.add(nueva);
            this.guardarBase();
        }
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
        this.clientes.put(nuevo.getCuit(), nuevo);
        this.guardarBase();
    }
    
    public void elimCliente(Cliente elim)
    {
        this.clientes.remove(elim.getCuit());
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
    
    public ArrayList<Usuario> arrayColaboradores()
    {
        ArrayList<Usuario> aux=new ArrayList<Usuario>();
        Iterator<Usuario> it = this.usuarios.values().iterator();
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

