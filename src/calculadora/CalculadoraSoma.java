package calculadora;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSoma extends JFrame {

    // Componentes
    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JButton botaoSomar;
    private JTextField campoResultado;

    public CalculadoraSoma() {
        setTitle("Calculadora de Soma");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Layout
        setLayout(new GridLayout(5, 1));

        // Campo 1
        campoNumero1 = new JTextField();
        add(new JLabel("Primeiro número:"));
        add(campoNumero1);

        // Campo 2
        campoNumero2 = new JTextField();
        add(new JLabel("Segundo número:"));
        add(campoNumero2);

        // Botão
        botaoSomar = new JButton("Somar");
        add(botaoSomar);

        // Resultado
        campoResultado = new JTextField();
        campoResultado.setEditable(false);
        add(new JLabel("Resultado:"));
        add(campoResultado);

        // Ação do botão
        botaoSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(campoNumero1.getText().trim());
                    int num2 = Integer.parseInt(campoNumero2.getText().trim());
                    int resultado = num1 + num2;
                    campoResultado.setText(String.valueOf(resultado));
                } catch (NumberFormatException ex) {
                    campoResultado.setText("Digite apenas números!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraSoma().setVisible(true);
        });
    }
}
