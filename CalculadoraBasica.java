import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraBasica {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Básica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JLabel label1 = new JLabel("Número 1:");
        JTextField textField1 = new JTextField();
        JLabel label2 = new JLabel("Número 2:");
        JTextField textField2 = new JTextField();
        JLabel labelResultado = new JLabel("Resultado:");
        JTextField textResultado = new JTextField();
        textResultado.setEditable(false);

        JButton btnSuma = new JButton("Suma");
        JButton btnResta = new JButton("Resta");
        JButton btnMultiplicacion = new JButton("Multiplicación");
        JButton btnDivision = new JButton("División");

        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(btnSuma);
        frame.add(btnResta);
        frame.add(btnMultiplicacion);
        frame.add(btnDivision);
        frame.add(labelResultado);
        frame.add(textResultado);

       
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double resultado = 0;

                    if (e.getSource() == btnSuma) {
                        resultado = num1 + num2;
                    } else if (e.getSource() == btnResta) {
                        resultado = num1 - num2;
                    } else if (e.getSource() == btnMultiplicacion) {
                        resultado = num1 * num2;
                    } else if (e.getSource() == btnDivision) {
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(frame, "No se puede dividir entre 0.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        resultado = num1 / num2;
                    }

                    textResultado.setText(String.valueOf(resultado));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        btnSuma.addActionListener(listener);
        btnResta.addActionListener(listener);
        btnMultiplicacion.addActionListener(listener);
        btnDivision.addActionListener(listener);

        frame.setVisible(true);
    }
}