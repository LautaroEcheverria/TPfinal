package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.BaseDatos;
import modelo.Usuario;

import vista.VentanaPrincipal;
import vista.VentanaUsuarioNuevo;

public class Controlador implements ActionListener
{
    private BaseDatos bd;
    private Usuario usuarioActual;
    private VentanaPrincipal ventanaPrincipal;
    
    public Controlador()
    {
        super();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO I
        if(e.getSource() instanceof JButton)
        {
            String botonclickeado = (String) e.getSource().toString();
            switch(botonclickeado.toUpperCase())
            {
                case ("CREAR USUARIO"): 
                    creaUsuario();
                break;
                case ("INICIAR SESION"):
                break;
                case ("CREAR TAREA"):
                break;
                case("ELIMINAR TAREA"):
                break;
                case("MODIFICAR ESTADO TAREA"):
                break;
                case ("GENERAR INFORME"):
                break;
                
            }
            
        }
    }
            
        public void creaUsuario()
        {
            Usuario nuevoUsuario= new Usuario();
            VentanaUsuarioNuevo ventanaUsuarioNuevo= new VentanaUsuarioNuevo(this.ventanaPrincipal,true,nuevoUsuario);
            
            
        }
    
}
