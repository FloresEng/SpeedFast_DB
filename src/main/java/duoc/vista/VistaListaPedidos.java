package duoc.vista;

import duoc.controlador.ControladorPedido;
import duoc.modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaListaPedidos extends JFrame {

    private JTable tabla;
    private DefaultTableModel model;
    private ControladorPedido control = new ControladorPedido();

    public VistaListaPedidos(){
        setTitle("Gestión de Pedidos");
        setSize(700,450);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Lista de Pedidos Existentes",SwingConstants.CENTER);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        add(lblTitulo, BorderLayout.NORTH);

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Dirección");
        model.addColumn("Tipo");
        model.addColumn("Estado");

        tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        //panel de botones
        JPanel panelAcciones = new JPanel();
        JButton btnActualizar = new JButton("Actualizar Tabla");
        JButton btnEliminar = new JButton("Eliminar Seleccionado");

        panelAcciones.add(btnActualizar);
        panelAcciones.add(btnEliminar);
        add(panelAcciones, BorderLayout.SOUTH);

        cargarDatos();//cargamos tabla

        btnActualizar.addActionListener(e-> cargarDatos());

        btnEliminar.addActionListener(e-> {
            int fila = tabla.getSelectedRow();
            if (fila == 1) {

                JOptionPane.showMessageDialog(this,"Seleccione un pedido de la lista.");
                return;
            }
            int id = (int) model.getValueAt(fila, 0);
            int confirmar = JOptionPane.showConfirmDialog(this,"¿Eliminar pedido con ID: "+id+"?","Confirmar",JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION){
                String msj = control.borrar(id);
                JOptionPane.showMessageDialog(this, msj);
                cargarDatos();//cargamos tabla nuevamente para ver cambios
            }
        });
    }

    private void cargarDatos(){
        model.setRowCount(0);//limpiamos la tabla para que no se acumule lo que mostramos
        List<Pedido> lista = control.obtenerTodos();

        if (lista !=null){
            for (Pedido p : lista){
                model.addRow(new Object[]{
                        p.getId(),
                        p.getDireccion(),
                        p.getTipo(),
                        p.getEstado()
                });
            }
        }
    }
}
