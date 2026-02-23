package duoc.vista;

import duoc.controlador.ControladorPedido;
import duoc.util.TipoPedido;

import javax.swing.*;
import java.awt.*;

public class VistaRegistroPedido extends JFrame {

    private JTextField txtDir = new JTextField();
    private JComboBox<TipoPedido> cbTipo = new JComboBox<>(TipoPedido.values());
    private ControladorPedido control = new ControladorPedido();

    public VistaRegistroPedido(){
        setTitle("Registrar nuevo Pedido");
        setSize(350,250);
        setLayout(new GridLayout(4,1,10,10));
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        add(new JLabel("Dirección de entrega:"));
        add(txtDir);
        add(new JLabel("Tipo de Pedido"));
        add(cbTipo);

        JButton btnGuardar = new JButton("Guardar Pedido");
        btnGuardar.addActionListener(e ->{
            String registro = control.registrar(txtDir.getText(), (TipoPedido)cbTipo.getSelectedItem());
            JOptionPane.showMessageDialog(this, registro);
            if (registro.contains("éxito")) dispose();

        });
        add(btnGuardar);

        setLocationRelativeTo(null);
    }
}
