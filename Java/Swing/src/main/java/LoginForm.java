import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel panelPrincipal;
    private JTextField usuarioTexto;
    private JPasswordField passwordTexto;
    private JButton enviarBoton;

    public LoginForm() {
        inicializar();
        enviarBoton.addActionListener(e -> validar());
    }

    private void validar() {
        var usuario = usuarioTexto.getText();
        var password =  new String(passwordTexto.getPassword());
        if (usuario.equals("root") && password.equals("admin")) {
            mostrarMensaje("Datos correctos, bienvenido");
        }else if (usuario.equals("root")) {
            mostrarMensaje("Password incorrecto");
        }else {
            mostrarMensaje("Usuario incorrecto");
        }
    }

    private void mostrarMensaje(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void inicializar() {
        setContentPane(panelPrincipal);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        LoginForm frame = new LoginForm();
        frame.setVisible(true);
    }

}
