package duoc.vista;

import duoc.controlador.ControladorCliente;
import duoc.controlador.ControladorPedido;
import duoc.util.TipoPedido;

import javax.swing.*;
import java.awt.*;

public class VistaRegistro extends JFrame {

    private JTextField txtDir = new JTextField(20);
    private JComboBox<TipoPedido> cbTipo = new JComboBox<>(TipoPedido.values());
    private ControladorPedido cp = new ControladorPedido();

    private JTextField txtNombre = new JTextField(20);
    private JTextField txtTelefono = new JTextField(20);
    private ControladorCliente cc = new ControladorCliente();

    //Constructor para pedido/cliente
    public VistaRegistro(String titulo) {
        setTitle(titulo);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        //Panel formulario
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        if (titulo.contains("Pedido")) {
            configurarPedido(formulario, gbc);
        } else {
            configurarCliente(formulario, gbc);
        }
        add(formulario, BorderLayout.CENTER);
    }

    private void configurarPedido(JPanel panel, GridBagConstraints gbc){
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Dirección:"), gbc);
        gbc.gridx = 1;
        panel.add(txtDir, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        panel.add(cbTipo, gbc);

        JButton btnGuardar = new JButton("Registrar Pedido");
        btnGuardar.addActionListener(e->{
            String eleccion = cp.registrar(txtDir.getText(),(TipoPedido)cbTipo.getSelectedItem());
            JOptionPane.showMessageDialog(this, eleccion);
            if (eleccion.contains("éxito")) dispose();

        });

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(btnGuardar, gbc);

    }

    private void configurarCliente(JPanel panel, GridBagConstraints gbc){
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre Cliente:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        panel.add(txtTelefono, gbc);

        JButton btnGuardar = new JButton("Registrar Cliente");
        btnGuardar.addActionListener(e->{
            String eleccion = cc.registrar(txtNombre.getText(),txtTelefono.getText());
            JOptionPane.showMessageDialog(this, eleccion);
            if (eleccion.contains("éxito")) dispose();

        });

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(btnGuardar, gbc);
    }
}
