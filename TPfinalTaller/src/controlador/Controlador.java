package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import javax.swing.JOptionPane;

import modelo.AbiertaState;
import modelo.BaseDatos;
import modelo.CerradaState;
import modelo.Cliente;
import modelo.Estado;
import modelo.GrupoDeClientes;
import modelo.PausaState;
import modelo.Servicio;
import modelo.Tarea;
import modelo.Usuario;

import vista.VentanaNuevoCliente;
import vista.VentanaPrincipal;
import vista.VentanaServicio;
import vista.VentanaUsuarioNuevo;

public class Controlador implements ActionListener,Observer
{
    private BaseDatos bd;
    private Usuario usuarioActual;
    private VentanaPrincipal ventanaPrincipal;
    
    public Controlador(BaseDatos bd)
    {
        super();
        this.bd = bd;
        this.bd.addObserver(this);
        this.ventanaPrincipal = new VentanaPrincipal(this);
        this.ventanaPrincipal.panelJcbGrupos(this.bd.getGrupoClientes());
        this.ventanaPrincipal.panelJListServicios(this.bd.arrayServicios());
        this.ventanaPrincipal.panelJlistClientes(this.bd.arrayClientes());
        this.ventanaPrincipal.panelJlistColaboradores(this.bd.arrayColaboradores());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO I
        if(e.getSource() instanceof JButton)
        {
            JButton aux = (JButton) e.getSource();
            String botonclickeado = (String) aux.getText();
            switch(botonclickeado.toUpperCase())
            {
                case ("CREAR USUARIO"): 
                    this.creaUsuario();
                break;
                case ("INICIAR SESION"):
                    this.iniciarSesion();
                break;
                case ("CREAR TAREA"):
                    this.crearTarea();
                break;
                case("ELIMINAR TAREA"):
                    this.eliminaTarea();
                break;
                case("MODIFICAR TAREA"):
                    this.modificaTarea();
                break;
                case ("GENERAR INFORME"):
                    this.generaInforme();
                break;
                case("CREAR GRUPO DE CLIENTES"):
                    this.crearGrupoClientes();
                break;
                case("CREAR CLIENTE"):
                    this.crearCliente();
                break;
                case("ELIMINAR CLIENTE"):
                    this.eliminarCliente();
                break;
                case("CREAR SERVICIO"):
                    this.creaServicio();
                break;
                case("ELIMINAR SERVICIO"):
                    this.elimServicio();
                break;
                case("CAMBIAR CONTRASEÑA"):
                    this.cambCont();
                break;
            }
        }
    }
    
    public void cambCont()
    {
        String nueva = this.ventanaPrincipal.ingresaDato("Ingrese nueva contraseña:");
        this.bd.cambioCont(this.usuarioActual,nueva);
    }
    
    public void generaInforme()
    {
        String tipoInforme = (String)this.ventanaPrincipal.getJcbInformes().getSelectedItem();
        switch (tipoInforme.toUpperCase())
        {
        case("TOTAL DE TAREAS"): 
            Cliente cliente = this.ventanaPrincipal.getJlClientes().getSelectedValue();
            String inicioS = this.ventanaPrincipal.ingresaDato("Ingrese el inicio del periodo");
            String finS = this.ventanaPrincipal.ingresaDato("Ingrese el fin del periodo");
            String inicio[] = inicioS.split("/");
            String fin[] = finS.split("/");
            GregorianCalendar inicioP = new GregorianCalendar(Integer.parseInt(inicio[2]),Integer.parseInt(inicio[1])+1,Integer.parseInt(inicio[0]));
            GregorianCalendar finP = new GregorianCalendar(Integer.parseInt(fin[2]),Integer.parseInt(fin[1])+1,Integer.parseInt(fin[0]));
            String informe = this.bd.tareasCliente(cliente, inicioP, finP);
            this.ventanaPrincipal.panelInformes(informe);
            break;
        case("TAREAS COLABORADOR"):
            Usuario colaborador = this.ventanaPrincipal.getJlColaboradores().getSelectedValue();
            inicioS = this.ventanaPrincipal.ingresaDato("Ingrese el inicio del periodo");
            finS = this.ventanaPrincipal.ingresaDato("Ingrese el fin del periodo");
            inicio= inicioS.split("/");
            fin= finS.split("/");
            inicioP = new GregorianCalendar(Integer.parseInt(inicio[2]),Integer.parseInt(inicio[1])+1,Integer.parseInt(inicio[0]));
            finP = new GregorianCalendar(Integer.parseInt(fin[2]),Integer.parseInt(fin[1])+1,Integer.parseInt(fin[0]));
            informe = this.bd.tareasColaborador(colaborador, inicioP, finP);
            this.ventanaPrincipal.panelInformes(informe);
            break;
        case("ESTADO DE TAREAS"):
            colaborador = this.ventanaPrincipal.getJlColaboradores().getSelectedValue();
            informe = this.bd.tareasEstado(colaborador);
            this.ventanaPrincipal.panelInformes(informe);
            break;
        case("TAREAS USUARIO"):
            colaborador = this.getUsuarioActual();
            String estado = this.ventanaPrincipal.ingresaDato("Ingrese el estado a filtrar");
            inicioS = this.ventanaPrincipal.ingresaDato("Ingrese el inicio del periodo");
            finS = this.ventanaPrincipal.ingresaDato("Ingrese el fin del periodo");
            inicio= inicioS.split("/");
            fin= finS.split("/");
            inicioP = new GregorianCalendar(Integer.parseInt(inicio[2]),Integer.parseInt(inicio[1])+1,Integer.parseInt(inicio[0]));
            finP = new GregorianCalendar(Integer.parseInt(fin[2]),Integer.parseInt(fin[1])+1,Integer.parseInt(fin[0]));
            informe = this.bd.tareasUsuario(colaborador, inicioP, finP, estado);
            this.ventanaPrincipal.panelInformes(informe);
            break;
        }
        
    }
    
    public void modificaTarea()
    {
        Tarea seleccionada = this.ventanaPrincipal.getJlTareas().getSelectedValue();
        if (seleccionada.getEstado_actual().cambiarEstado())
        {
            String estado = this.ventanaPrincipal.ingresaDato("Ingrese estado a cambiar:("+seleccionada.getEstado_actual().cambioPosible()+")");
            if (estado.equalsIgnoreCase("ABIERTA"))
                seleccionada.setEstado_actual(new AbiertaState(seleccionada));
            else
                if (estado.equalsIgnoreCase("PAUSA"))
                    seleccionada.setEstado_actual(new PausaState(seleccionada));
                else
                    seleccionada.setEstado_actual(new CerradaState(seleccionada));    
            this.bd.guardarBase();
        }
        else
            JOptionPane.showMessageDialog(this.ventanaPrincipal, "No se puede cambiar estado");
    }
    public void creaServicio()
    {
        Servicio nuevo = new Servicio();
        VentanaServicio ventanaAux = new VentanaServicio(this.ventanaPrincipal,true,nuevo,this.bd);
    }
    
    public void elimServicio()
    {
        this.bd.elimServicio(this.ventanaPrincipal.getJlServicios().getSelectedValue());
    }
    
    public void crearCliente()
    {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setGrupos_de_clientes((GrupoDeClientes)this.ventanaPrincipal.getJcbGrupos().getSelectedItem());
        VentanaNuevoCliente ventanaAux = new VentanaNuevoCliente(this.ventanaPrincipal,true,nuevoCliente,this.bd);
    }
    
    public void eliminarCliente()
    {
        this.bd.elimCliente(this.ventanaPrincipal.getJlClientes().getSelectedValue());
    }
    
    public void crearGrupoClientes()
    {
        GrupoDeClientes nuevo = new GrupoDeClientes();
        String nombreGrupo = this.ventanaPrincipal.ingresaDato("Ingrese nombre del grupo:");
        nuevo.setNombre_grupo(nombreGrupo);
        this.bd.agregaGrupoClientes(nuevo);
    }
    
    public void crearTarea()
    {
        Tarea tarea=new Tarea();    
        tarea.setColaborador(this.usuarioActual);
        tarea.setCliente(this.ventanaPrincipal.getJlClientes().getSelectedValue());
        tarea.setServicio(this.ventanaPrincipal.getJlServicios().getSelectedValue());
        tarea.setEstado_actual(new AbiertaState(tarea));
        this.bd.agregaTarea(tarea);
    }        
    
    public void eliminaTarea()
    {
        this.bd.elimTarea(this.ventanaPrincipal.getJlTareas().getSelectedValue());
    }
    
    public void creaUsuario()
    {
        Usuario nuevoUsuario= new Usuario();
        VentanaUsuarioNuevo ventanaAux= new VentanaUsuarioNuevo(this.ventanaPrincipal,true,nuevoUsuario,this.bd);
    }
    
    public void iniciarSesion() 
    {
        String usuario = this.ventanaPrincipal.getJtfUsuario().getText();
        String contr = this.ventanaPrincipal.getJtfContrasena().getText();        
        this.usuarioActual = this.bd.compruebaUsuario(usuario,contr);
        if (this.usuarioActual == null)
        {
            
        }
        else
        {
            this.ventanaPrincipal.panelTareas(this.bd.tareasUsuario(this.usuarioActual));
            if (this.usuarioActual.getPerfil().equalsIgnoreCase("ADMINISTRADOR"))
                this.ventanaPrincipal.botonesAdministrador();
            else
                this.ventanaPrincipal.botonesColaborador();
        }
    }

    public void setUsuarioActual(Usuario usuarioActual)
    {
        this.usuarioActual = usuarioActual;
    }

    public Usuario getUsuarioActual()
    {
        return usuarioActual;
    }

    @Override
    public void update(Observable observable, Object object)
    {
        // TODO Implement this method
        this.ventanaPrincipal.panelJcbGrupos(this.bd.getGrupoClientes());
        this.ventanaPrincipal.panelJListServicios(this.bd.arrayServicios());
        this.ventanaPrincipal.panelJlistClientes(this.bd.arrayClientes());
        this.ventanaPrincipal.panelJlistColaboradores(this.bd.arrayColaboradores());
        if (this.usuarioActual != null)
            this.ventanaPrincipal.panelTareas(this.bd.tareasUsuario(this.usuarioActual));
    }
}

