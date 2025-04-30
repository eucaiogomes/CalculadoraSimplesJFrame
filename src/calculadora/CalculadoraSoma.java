import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSomaDesign extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JButton botaoSomar;
    private JTextField campoResultado;

    public CalculadoraSomaDesign() {
        setTitle("Calculadora de Soma");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza

        // Painel principal com padding e cor
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(245, 245, 250));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(painel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // espaçamento entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fontePadrao = new Font("Segoe UI", Font.PLAIN, 16);

        // Campo 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(new JLabel("Primeiro número:"), gbc);

        gbc.gridx = 1;
        campoNumero1 = new JTextField();
        campoNumero1.setFont(fontePadrao);
        painel.add(campoNumero1, gbc);

        // Campo 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel("Segundo número:"), gbc);

        gbc.gridx = 1;
        campoNumero2 = new JTextField();
        campoNumero2.setFont(fontePadrao);
        painel.add(campoNumero2, gbc);

        // Botão Somar
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        botaoSomar = new JButton("➕ Somar");
        botaoSomar.setFont(fontePadrao);
        botaoSomar.setBackground(new Color(70, 130, 180));
        botaoSomar.setForeground(Color.WHITE);
        botaoSomar.setFocusPainted(false);
        painel.add(botaoSomar, gbc);

        // Campo Resultado
        gbc.gridy = 3;
        campoResultado = new JTextField();
        campoResultado.setFont(fontePadrao);
        campoResultado.setEditable(false);
        campoResultado.setHorizontalAlignment(JTextField.CENTER);
        campoResultado.setBackground(new Color(230, 230, 230));
        painel.add(campoResultado, gbc);

        // Ação do botão
        botaoSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(campoNumero1.getText().trim());
                    int num2 = Integer.parseInt(campoNumero2.getText().trim());
                    int resultado = num1 + num2;
                    campoResultado.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    campoResultado.setText("❌ Digite apenas números válidos!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraSomaDesign().setVisible(true);
        });
    }
}
