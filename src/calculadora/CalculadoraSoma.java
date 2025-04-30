package calculadora;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSoma extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JButton botaoSomar;
    private JTextField campoResultado;

    public CalculadoraSoma() {
        setTitle("🧮 Calculadora Amigável");
        setSize(420, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar janela

        // Painel principal
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(250, 250, 255)); // cor suave
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        add(painel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fontePadrao = new Font("Segoe UI", Font.PLAIN, 17);
        Font fonteTitulo = new Font("Segoe UI", Font.BOLD, 22);

        // Título
        JLabel titulo = new JLabel("Calculadora de Soma");
        titulo.setFont(fonteTitulo);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(titulo, gbc);

        // Campo 1
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        painel.add(new JLabel("🔢 Primeiro número:"), gbc);

        gbc.gridx = 1;
        campoNumero1 = new JTextField();
        campoNumero1.setFont(fontePadrao);
        painel.add(campoNumero1, gbc);

        // Campo 2
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(new JLabel("🔢 Segundo número:"), gbc);

        gbc.gridx = 1;
        campoNumero2 = new JTextField();
        campoNumero2.setFont(fontePadrao);
        painel.add(campoNumero2, gbc);

        // Botão
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        botaoSomar = new JButton("➕ Somar");
        botaoSomar.setFont(fontePadrao);
        botaoSomar.setBackground(new Color(100, 149, 237));
        botaoSomar.setForeground(Color.WHITE);
        botaoSomar.setFocusPainted(false);
        botaoSomar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        painel.add(botaoSomar, gbc);

        // Resultado
        gbc.gridy = 4;
        campoResultado = new JTextField();
        campoResultado.setFont(fontePadrao);
        campoResultado.setHorizontalAlignment(JTextField.CENTER);
        campoResultado.setEditable(false);
        campoResultado.setBackground(new Color(230, 240, 250));
        campoResultado.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237)));
        painel.add(campoResultado, gbc);

        // Evento do botão
        botaoSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(campoNumero1.getText().trim());
                    int num2 = Integer.parseInt(campoNumero2.getText().trim());
                    int resultado = num1 + num2;
                    campoResultado.setForeground(new Color(0, 128, 0));
                    campoResultado.setText("✅ Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    campoResultado.setForeground(Color.RED);
                    campoResultado.setText("❌ Por favor, digite apenas números.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraSoma().setVisible(true));
    }
}
