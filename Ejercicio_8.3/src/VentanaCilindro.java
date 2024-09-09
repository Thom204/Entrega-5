import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCilindro extends JFrame {
    private JTextField txtRadio, txtAltura;
    private JLabel lblVolumen, lblSuperficie;

    public VentanaCilindro() {
        setTitle("Cilindro");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));
        setResizable(false);

        add(new JLabel("Radio:"));
        txtRadio = new JTextField();
        add(txtRadio);

        add(new JLabel("Altura:"));
        txtAltura = new JTextField();
        add(txtAltura);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Verifica que los campos no estén vacíos
                    if (txtRadio.getText().isEmpty() || txtAltura.getText().isEmpty()) {
                        throw new IllegalArgumentException("Todos los campos deben estar llenos.");
                    }

                    // Intenta parsear los valores como double
                    double radio = Double.parseDouble(txtRadio.getText());
                    double altura = Double.parseDouble(txtAltura.getText());

                    // Verifica que los valores sean positivos
                    if (radio <= 0 || altura <= 0) {
                        throw new IllegalArgumentException("El radio y la altura deben ser positivos.");
                    }

                    Cilindro cilindro = new Cilindro(radio, altura);
                    lblVolumen.setText("Volumen: " + cilindro.calcularVolumen());
                    lblSuperficie.setText("Superficie: " + cilindro.calcularSuperficie());
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
