package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import javax.swing.JOptionPane;

import modelo.BaseDatos;
import modelo.GrupoDeClientes;
import modelo.Tarea;
import modelo.Usuario;

import vista.VentanaPrincipal;
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
                break;
                case("ELIMINAR TAREA"):
                break;
                case("MODIFICAR ESTADO TAREA"):
                break;
                case ("GENERAR INFORME"):
                break;
                case("CREAR GRUPO DE CLIENTES"):
                    this.crearGrupoClientes();
                break;
            }
        }
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
    }        
    
    public void creaUsuario()
    {
        Usuario nuevoUsuario= new Usuario();
        VentanaUsuarioNuevo ventanaUsuarioNuevo= new VentanaUsuarioNuevo(this.ventanaPrincipal,true,nuevoUsuario,this.bd);
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
        
    }
}

