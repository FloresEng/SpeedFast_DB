package duoc.vista;

import javax.swing.*;
import java.awt.*;

public class VistaLogin extends JFrame {

    private JTextField txtUser = new JTextField();
    private JPasswordField txtPw = new JPasswordField();
    private JButton btnEntrar = new JButton("Iniciar Sesión");

    public VistaLogin(){
        setTitle("SpeedFast - Acceso a Sistema");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2, 10,10));
        setLocationRelativeTo(null);

        add(new JLabel(" Usuario:")); add(txtUser);
        add(new JLabel(" Contraseña")); add(txtPw);
        add(new JLabel("")); add(btnEntrar);

        btnEntrar.addActionListener(e -> validar());
    }

    private void validar(){
        if (txtUser.getText().equals("admin") && new String(txtPw.getPassword()).equals("Admin01.")){
            JOptionPane.showMessageDialog(this,"Bienvenido al Sistema SpeedFast, admin!");
            new VistaMainMenu().setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas.","¡ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
