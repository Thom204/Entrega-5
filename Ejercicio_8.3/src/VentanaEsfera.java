import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEsfera extends JFrame {
    private JTextField txtRadio;
    private JLabel lblVolumen, lblSuperficie;

    public VentanaEsfera() {
        setTitle("Esfera");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));
        setResizable(false);

        add(new JLabel("Radio:"));
        txtRadio = new JTextField();
        add(txtRadio);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Verifica que el campo no esté vacío
                    if (txtRadio.getText().isEmpty()) {
                        throw new IllegalArgumentException("El campo de radio debe estar lleno.");
                    }

                    // Intenta parsear el valor como double
                    double radio = Double.parseDouble(txtRadio.getText());

                    // Verifica que el valor sea positivo
                    if (radio <= 0) {
                        throw new IllegalArgumentException("El radio debe ser positivo.");
                    }

                    Esfera esfera = new Esfera(radio);
                    lblVolumen.setText("Volumen: " + esfera.calcularVolumen());
                    lblSuperficie.setText("Superficie: " + esfera.calcularSuperficie());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
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
