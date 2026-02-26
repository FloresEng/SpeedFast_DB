package duoc.vista;

import duoc.controlador.ControladorPedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
    }
}
