package duoc.vista;

import javax.swing.*;
import java.awt.*;

public class VistaMainMenu extends JFrame {

    public VistaMainMenu(){
        setTitle("SpeedFast - Panel de Gestión");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Elija acción a realizar.", SwingConstants.CENTER);
        add(lblTitulo, BorderLayout.NORTH);

        //Panel CRUD
        JPanel panelBotones = new JPanel(new GridLayout(2,2,20,20));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        JButton btnCrearPedido = new JButton("Crear Pedido");
        JButton btnCrearCliente = new JButton("Crear Cliente");
        JButton btnListar = new JButton("Listar (Ver todo / Eliminar)");
        JButton btnEntregas = new JButton("Gestión de Entregas.");

        panelBotones.add(btnCrearPedido);
        panelBotones.add(btnCrearCliente);
        panelBotones.add(btnListar);
        panelBotones.add(btnEntregas);

        add(panelBotones, BorderLayout.CENTER);

        btnCrearPedido.addActionListener(e-> new VistaRegistro("Registrar Pedido").setVisible(true));
        btnCrearCliente.addActionListener(e-> new VistaRegistro("Registrar Cliente").setVisible(true));
        btnEntregas.addActionListener(e-> new VistaEntrega().setVisible(true));
        btnListar.addActionListener(e->{
            String[] opciones = {"Pedidos","Clientes", "Cancelar"};

            int seleccion = JOptionPane.showOptionDialog(
                    this,"Seleccione listado a visualizar:","Consulta de Registros a BD",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[0]
            );

            if (seleccion == 0) {//Pedidos
                new VistaListaPedidos().setVisible(true);
            }else if (seleccion == 1){//Clientes
                new VistaListaClientes().setVisible(true);
            }
        });

    }
}
