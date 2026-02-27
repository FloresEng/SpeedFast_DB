package duoc.vista;

import duoc.controlador.ControladorEntrega;
import duoc.controlador.ControladorPedido;
import duoc.modelo.Pedido;
import duoc.util.EstadoPedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaEntrega extends JFrame {

    private JTable tabla;
    private DefaultTableModel model;
    private ControladorPedido cp = new ControladorPedido();
    private ControladorEntrega ce = new ControladorEntrega();

    private JTextField txtNomRepar = new JTextField(5);

    public VistaEntrega(){
        setTitle("Gestión de Entregas");
        setSize(600,400);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tipo Pedido");
        model.addColumn("Estado Pedido");

        tabla = new JTable(model);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JButton btnAsignar = new JButton("Asignar y Despachar");
        btnAsignar.addActionListener(e->{
            int filaA = tabla.getSelectedRow();
            if (filaA == -1){
                JOptionPane.showMessageDialog(this,"Seleccione un pedido.");
                return;
            }
            if (txtNomRepar.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this,"Ingrese el nombre del repartidor");
                return;
            }

            try{
                int idPedido = (int) model.getValueAt(filaA,0);
                String nomRepartidor = txtNomRepar.getText().trim();

                String resultado = ce.iniciarEntrega(idPedido,nomRepartidor);

                JOptionPane.showMessageDialog(this, resultado);

                txtNomRepar.setText("");
                cargarPedidosPendientes();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error al asignar repartidor.");
            }
        });

        JButton btnFinalizar = new JButton("Finalizar Entrega");
        btnFinalizar.addActionListener(ev->{
            int filaF = tabla.getSelectedRow();
            if (filaF == -1){
                JOptionPane.showMessageDialog(this,"Seleccione un pedido.");
                return;
            }
            try{
                int idPedido = (int) model.getValueAt(filaF,0);

                String eleccion = ce.finalizarEntrega(idPedido);

                JOptionPane.showMessageDialog(this, eleccion);

                cargarPedidosEnReparto();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Error al intentar finalizar la entrega.");
            }
        });

        JPanel panelAcciones = new JPanel();
        JButton btnPendientes = new JButton("Ver Pendientes");
        JButton btnEnReparto = new JButton("Ver En Reparto");

        panelAcciones.add(btnPendientes);
        panelAcciones.add(btnEnReparto);
        add(panelAcciones, BorderLayout.NORTH);
    }

    private void cargarPedidosPendientes() {
        model.setRowCount(0);
        List<Pedido> lista = cp.obtenerTodos();

        for (Pedido p : lista) {
            //mostramos solo los pendientes
            if (p.getEstado() == EstadoPedido.PENDIENTE) {
                model.addRow(new Object[]{
                        p.getId(),
                        p.getTipo(),
                        p.getEstado()
                });
            }
        }
    }

    private void cargarPedidosEnReparto(){
        model.setRowCount(0);
        List<Pedido> lista = cp.obtenerTodos();

        for (Pedido p : lista){
            if (p.getEstado() == EstadoPedido.EN_REPARTO){
                model.addRow(new Object[]{
                        p.getId(),
                        p.getTipo(),
                        p.getEstado()
                });
            }
        }
    }
}
