package duoc.vista;

import duoc.conexion.ConexionBD;
import duoc.controlador.ControladorCliente;
import duoc.dao.ClienteDAO;
import duoc.modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VistaListaClientes extends JFrame {
    private JTable tabla;
    private DefaultTableModel model;
    private ControladorCliente control = new ControladorCliente();

    public VistaListaClientes() {
        setTitle("Gestión de Clientes");
        setSize(600,400);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Teléfono");

        tabla = new JTable(model);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JButton btnActualizar = new JButton("Actualizar Teléfono");
        btnActualizar.addActionListener(e->{
            int fila = tabla.getSelectedRow();
            if (fila == -1){
                JOptionPane.showMessageDialog(this,"Seleccione un cliente.");
                return;
            }
            int id = (int) model.getValueAt(fila,0);
            String nombre = (String) model.getValueAt(fila,1);
            String fono = (String) model.getValueAt(fila, 2);

            String nuevoFono = JOptionPane.showInputDialog(this,"Actualizar teléfono para: "+nombre);

            if (nuevoFono != null && !nuevoFono.trim().isEmpty()){
                try{
                    try(Connection conn = ConexionBD.obtenerConexion()){
                        ClienteDAO cdao = new ClienteDAO();
                        cdao.actualizar(id, nuevoFono, conn);
                        JOptionPane.showMessageDialog(this, "Teléfono actualizado con éxito.");
                        cargarDatos();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this,"Error al actualizar: "+ex.getMessage());
                }
            }
        });

        JButton btnEliminar = new JButton("Eliminar Cliente");
        btnEliminar.addActionListener(e->{
            int fila = tabla.getSelectedRow();
            if (fila != -1){
                int id = (int) model.getValueAt(fila,0);
                String respuesta = control.eliminarCliente(id);
                JOptionPane.showMessageDialog(this,respuesta);
                cargarDatos();
            }
        });

        JPanel panelAcciones = new JPanel();
        panelAcciones.add(btnEliminar);
        panelAcciones.add(btnActualizar);
        add(panelAcciones,BorderLayout.SOUTH);
        cargarDatos();
    }

    private void cargarDatos(){
        model.setRowCount(0);//limpiamos tabla
        List<Cliente> lista = control.obtenerTodos();
        if (lista != null){
            for (Cliente c : lista){
                model.addRow(new Object[]{
                        c.getId(),
                        c.getNombre(),
                        c.getTelefono()
                });
            }
        }
    }
}
