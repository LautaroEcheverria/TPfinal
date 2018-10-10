
package vista;

import controlador.Controlador;

import java.awt.Dimension;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Cliente;
import modelo.GrupoDeClientes;
import modelo.Servicio;
import modelo.Tarea;

/**
 *
 * @author usuario
 */
public class VentanaPrincipal extends javax.swing.JFrame
{
    /** Creates new form VentanaPrincipal */
    public VentanaPrincipal(Controlador c)
    {
        initComponents();
        this.jbCreaTarea.addActionListener(c);
        this.jbCreaUsuario.addActionListener(c);
        this.jbGeneraInf.addActionListener(c);
        this.jbIniciaSesion.addActionListener(c);
        this.jbModificarTarea.addActionListener(c);
        this.jbCrearGrupos.addActionListener(c);
        this.jbIniciaSesion.addActionListener(c);
        this.jbCrearCliente.addActionListener(c);
        this.jbElimTarea.addActionListener(c);
        this.jbElimCliente.addActionListener(c);
        this.jbCreaServ.addActionListener(c);
        this.jbElimServ.addActionListener(c);
        this.jtaInformes.setEditable(false);
        this.setSize(1200,800);
        this.sesionActualNul();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void panelTareas(ArrayList<Tarea> tareas)
    {
        if (tareas != null)
        {
            this.jlTareas.removeAll();
            DefaultListModel<Tarea> model = new DefaultListModel<Tarea>();
            Iterator<Tarea> it = tareas.iterator();
            while (it.hasNext())
            {
                model.addElement(it.next());
            }
            this.jlTareas.setModel(model);
            this.jlTareas.repaint();
        }
    }
    
    public void panelJlistClientes(ArrayList<Cliente> clientes)
    {
        if (clientes != null)
        {
            this.jlClientes.removeAll();
            DefaultListModel model = new DefaultListModel();
            Iterator<Cliente> it = clientes.iterator();
            while (it.hasNext())
            {
                model.addElement(it.next());
            }
            this.jlClientes.setModel(model);
            this.jlClientes.repaint();
        }
    }
    
    public void panelJListServicios(ArrayList<Servicio> servicios)
    {
        if (servicios != null)
        {
            this.jlServicios.removeAll();
            DefaultListModel model = new DefaultListModel();
            Iterator<Servicio> it = servicios.iterator();
            while (it.hasNext())
            {
                model.addElement(it.next());
            }
            this.jlServicios.setModel(model);
            this.jlServicios.repaint();
        }
    }
    
    public void panelJcbGrupos(HashMap<String,GrupoDeClientes> grupos)
    {
        if (grupos != null)
        {
            this.jcbGrupos.removeAllItems();
            Iterator<GrupoDeClientes> it = grupos.values().iterator();
            while (it.hasNext())
            {
                this.jcbGrupos.addItem(it.next());
            }
        }
    }
    
    public String ingresaDato(String mensaje)
    {
        return JOptionPane.showInputDialog(this, mensaje);
    }
    
    public void botonesAdministrador()
    {
        this.jbCreaTarea.setEnabled(true);
        this.jbCreaUsuario.setEnabled(true);
        this.jbGeneraInf.setEnabled(true);
        this.jbIniciaSesion.setEnabled(true);
        this.jbElimTarea.setEnabled(true);
        this.jbModificarTarea.setEnabled(true);
        this.jbCrearGrupos.setEnabled(true);
        this.jbIniciaSesion.setEnabled(true);
        this.jbCrearCliente.setEnabled(true);
        this.jbElimCliente.setEnabled(true);
        this.jbCreaServ.setEnabled(true);
        this.jbElimServ.setEnabled(true);
    }
    
    public void botonesColaborador()
    {
        this.jbCreaTarea.setEnabled(true);
        this.jbCreaUsuario.setEnabled(false);
        this.jbGeneraInf.setEnabled(false);
        this.jbIniciaSesion.setEnabled(true);
        this.jbElimTarea.setEnabled(true);
        this.jbModificarTarea.setEnabled(true);
        this.jbCrearGrupos.setEnabled(false);
        this.jbIniciaSesion.setEnabled(true);
        this.jbCrearCliente.setEnabled(false);
        this.jbElimCliente.setEnabled(false);
        this.jbCreaServ.setEnabled(false);
        this.jbElimServ.setEnabled(false);
    }
    
    public void sesionActualNul()
    {
        this.jbCreaTarea.setEnabled(false);
        this.jbCreaUsuario.setEnabled(true);
        this.jbGeneraInf.setEnabled(false);
        this.jbIniciaSesion.setEnabled(false);
        this.jbModificarTarea.setEnabled(false);
        this.jbElimTarea.setEnabled(false);
        this.jbCrearGrupos.setEnabled(false);
        this.jbIniciaSesion.setEnabled(true);
        this.jbCrearCliente.setEnabled(false);
        this.jbElimCliente.setEnabled(false);
        this.jbCreaServ.setEnabled(false);
        this.jbElimServ.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents()//GEN-BEGIN:initComponents
    {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfContrasena = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jbIniciaSesion = new javax.swing.JButton();
        jbCreaUsuario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jbCreaTarea = new javax.swing.JButton();
        jbModificarTarea = new javax.swing.JButton();
        jbElimTarea = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jcbInformes = new javax.swing.JComboBox<>();
        jbGeneraInf = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jbCrearCliente = new javax.swing.JButton();
        jbElimCliente = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jbCrearGrupos = new javax.swing.JButton();
        jcbGrupos = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jbCreaServ = new javax.swing.JButton();
        jbElimServ = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlTareas = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaInformes = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlClientes = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlServicios = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 4));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setText("Usuario:");
        jPanel4.add(jLabel1);

        jtfUsuario.setPreferredSize(new java.awt.Dimension(90, 19));
        jtfUsuario.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jtfUsuarioActionPerformed(evt);
            }
        });
        jPanel4.add(jtfUsuario);

        jPanel2.add(jPanel4);

        jLabel2.setText("Contraseña:");
        jPanel5.add(jLabel2);

        jtfContrasena.setPreferredSize(new java.awt.Dimension(90, 19));
        jtfContrasena.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jtfContrasenaActionPerformed(evt);
            }
        });
        jPanel5.add(jtfContrasena);

        jPanel2.add(jPanel5);

        jbIniciaSesion.setText("Iniciar Sesion");
        jPanel6.add(jbIniciaSesion);

        jbCreaUsuario.setText("Crear Usuario");
        jPanel6.add(jbCreaUsuario);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jbCreaTarea.setText("Crear Tarea");
        jPanel8.add(jbCreaTarea);

        jbModificarTarea.setText("Modificar Tarea");
        jPanel8.add(jbModificarTarea);

        jbElimTarea.setText("Eliminar Tarea");
        jPanel8.add(jbElimTarea);

        jPanel3.add(jPanel8);

        jcbInformes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Total de tareas", "Tareas Colaborador", "Estado de tareas", "Tareas Usuario" }));
        jcbInformes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jcbInformesActionPerformed(evt);
            }
        });
        jPanel10.add(jcbInformes);

        jbGeneraInf.setText("Generar Informe");
        jPanel10.add(jbGeneraInf);

        jPanel3.add(jPanel10);

        jPanel1.add(jPanel3);

        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jbCrearCliente.setText("Crear Cliente");
        jPanel12.add(jbCrearCliente);

        jbElimCliente.setText("Eliminar Cliente");
        jbElimCliente.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbElimClienteActionPerformed(evt);
            }
        });
        jPanel12.add(jbElimCliente);

        jPanel9.add(jPanel12);

        jbCrearGrupos.setText("Crear Grupo de Clientes");
        jPanel13.add(jbCrearGrupos);

        jPanel13.add(jcbGrupos);

        jPanel9.add(jPanel13);

        jPanel1.add(jPanel9);

        jbCreaServ.setText("Crear Servicio");
        jPanel11.add(jbCreaServ);

        jbElimServ.setText("Eliminar Servicio");
        jPanel11.add(jbElimServ);

        jPanel1.add(jPanel11);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel7.setLayout(new java.awt.GridLayout(1, 4));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tareas"));
        jScrollPane2.setToolTipText("");

        jScrollPane2.setViewportView(jlTareas);

        jPanel7.add(jScrollPane2);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informes"));

        jtaInformes.setColumns(20);
        jtaInformes.setRows(5);
        jScrollPane1.setViewportView(jtaInformes);

        jPanel7.add(jScrollPane1);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jScrollPane3.setViewportView(jlClientes);

        jPanel7.add(jScrollPane3);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Servicios"));

        jScrollPane4.setViewportView(jlServicios);

        jPanel7.add(jScrollPane4);

        getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void jcbInformesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jcbInformesActionPerformed
    {//GEN-HEADEREND:event_jcbInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbInformesActionPerformed

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jtfUsuarioActionPerformed
    {//GEN-HEADEREND:event_jtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsuarioActionPerformed

    private void jtfContrasenaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jtfContrasenaActionPerformed
    {//GEN-HEADEREND:event_jtfContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfContrasenaActionPerformed

    private void jbElimClienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jbElimClienteActionPerformed
    {//GEN-HEADEREND:event_jbElimClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbElimClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbCreaServ;
    private javax.swing.JButton jbCreaTarea;
    private javax.swing.JButton jbCreaUsuario;
    private javax.swing.JButton jbCrearCliente;
    private javax.swing.JButton jbCrearGrupos;
    private javax.swing.JButton jbElimCliente;
    private javax.swing.JButton jbElimServ;
    private javax.swing.JButton jbElimTarea;
    private javax.swing.JButton jbGeneraInf;
    private javax.swing.JButton jbIniciaSesion;
    private javax.swing.JButton jbModificarTarea;
    private javax.swing.JComboBox<GrupoDeClientes> jcbGrupos;
    private javax.swing.JComboBox<String> jcbInformes;
    private javax.swing.JList<Cliente> jlClientes;
    private javax.swing.JList<Servicio> jlServicios;
    private javax.swing.JList<Tarea> jlTareas;
    private javax.swing.JTextArea jtaInformes;
    private javax.swing.JTextField jtfContrasena;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables

    
    
    public void setJtfContrasena(JTextField jtfContrasena)
    {
        this.jtfContrasena = jtfContrasena;
    }

    public JTextField getJtfContrasena() 
    {
        return jtfContrasena;
    }


    public void setJlClientes(JList<Cliente> jlClientes)
    {
        this.jlClientes = jlClientes;
    }

    public JList<Cliente> getJlClientes()
    {
        return jlClientes;
    }

    public void setJlServicios(JList<Servicio> jlServicios)
    {
        this.jlServicios = jlServicios;
    }

    public JList<Servicio> getJlServicios()
    {
        return jlServicios;
    }

    public void setJlTareas(JList<Tarea> jlTareas)
    {
        this.jlTareas = jlTareas;
    }

    public JList<Tarea> getJlTareas()
    {
        return jlTareas;
    }

    public void setJtfUsuario(JTextField jtfUsuario) 
    {
        this.jtfUsuario = jtfUsuario;
    }

    public JTextField getJtfUsuario() 
    {
        return jtfUsuario;
    }

    public void setJcbGrupos(JComboBox<GrupoDeClientes> jcbGrupos)
    {
        this.jcbGrupos = jcbGrupos;
    }

    public JComboBox<GrupoDeClientes> getJcbGrupos()
    {
        return jcbGrupos;
    }


    public void setJcbInformes(JComboBox<String> jcbInformes)
    {
        this.jcbInformes = jcbInformes;
    }

    public JComboBox<String> getJcbInformes()
    {
        return jcbInformes;
    }
}
