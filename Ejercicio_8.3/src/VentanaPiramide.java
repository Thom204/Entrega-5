import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPiramide extends JFrame {
    private JTextField txtBase, txtAltura, txtApotema;
    private JLabel lblVolumen, lblSuperficie;

    public VentanaPiramide() {
        setTitle("Pirámide");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Base:"));
        txtBase = new JTextField();
        add(txtBase);

        add(new JLabel("Altura:"));
        txtAltura = new JTextField();
        add(txtAltura);

        add(new JLabel("Apotema:"));
        txtApotema = new JTextField();
        add(txtApotema);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Verifica que los campos no estén vacíos
                    if (txtBase.getText().isEmpty() || txtAltura.getText().isEmpty() || txtApotema.getText().isEmpty()) {
                        throw new IllegalArgumentException("Todos los campos deben estar llenos.");
                    }

                    // Intenta parsear los valores como double
                    double base = Double.parseDouble(txtBase.getText());
                    double altura = Double.parseDouble(txtAltura.getText());
                    double apotema = Double.parseDouble(txtApotema.getText());

                    // Verifica que los valores sean positivos
                    if (base <= 0 || altura <= 0 || apotema <= 0) {
                        throw new IllegalArgumentException("La base, altura y apotema deben ser positivos.");
                    }

                    Piramide piramide = new Piramide(base, altura, apotema);
                    lblVolumen.setText("Volumen: " + piramide.calcularVolumen());
                    lblSuperficie.setText("Superficie: " + piramide.calcularSuperficie());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(btnCalcular);

        lblVolumen = new JLabel("Volumen: ");
        add(lblVolumen);
        lblSuperficie = new JLabel("Superficie: ");
        add(lblSuperficie);
    }
}
