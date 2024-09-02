import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Calculadora de Figuras Geométricas");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JButton btnCilindro = new JButton("Cilindro");
        JButton btnEsfera = new JButton("Esfera");
        JButton btnPiramide = new JButton("Pirámide");

        btnCilindro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaCilindro().setVisible(true);
            }
        });

        btnEsfera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaEsfera().setVisible(true);
            }
        });

        btnPiramide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaPiramide().setVisible(true);
            }
        });

        add(btnCilindro);
        add(btnEsfera);
        add(btnPiramide);
    }

    public static void main(String[] args) {
        new VentanaPrincipal().setVisible(true);
    }
}
