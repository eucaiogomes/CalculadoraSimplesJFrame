package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSoma extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JTextField campoResultado;
    private JButton botaoSomar;
    private JButton botaoSubtrair;
    private JButton botaoMultiplicar;
    private JButton botaoDividir;

    public CalculadoraSoma() {
        setTitle("🧮 Calculadora Amigável");
        setSize(420, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar janela

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); // Usando BoxLayout para melhor controle dos componentes
        painel.setBackground(new Color(250, 250, 255)); // cor suave
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        add(painel);

        // Fonte para os componentes
        Font fontePadrao = new Font("Segoe UI", Font.PLAIN, 17);
        Font fonteTitulo = new Font("Segoe UI", Font.BOLD, 22);

        // Título
        JLabel titulo = new JLabel("Calculadora");
        titulo.setFont(fonteTitulo);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(titulo);

        // Espaço entre título e próximo componente
        painel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Campo 1
        JPanel painelCampo1 = new JPanel();
        painelCampo1.setLayout(new BoxLayout(painelCampo1, BoxLayout.X_AXIS));
        painelCampo1.add(new JLabel("🔢 Primeiro número: "));
        campoNumero1 = new JTextField(10);
        campoNumero1.setFont(fontePadrao);
        painelCampo1.add(campoNumero1);
        painel.add(painelCampo1);

        // Campo 2
        JPanel painelCampo2 = new JPanel();
        painelCampo2.setLayout(new BoxLayout(painelCampo2, BoxLayout.X_AXIS));
        painelCampo2.add(new JLabel("🔢 Segundo número: "));
        campoNumero2 = new JTextField(10);
        campoNumero2.setFont(fontePadrao);
        painelCampo2.add(campoNumero2);
        painel.add(painelCampo2);

        // Espaço entre os campos e os botões
        painel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Botões de operações
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(2, 2, 10, 10)); // Usando GridLayout para os botões
        botaoSomar = new JButton("➕ Somar");
        botaoSomar.setFont(fontePadrao);
        botaoSomar.setBackground(new Color(100, 149, 237)); // Azul
        botaoSomar.setForeground(Color.WHITE);
        painelBotoes.add(botaoSomar);

        botaoSubtrair = new JButton("➖ Subtrair");
        botaoSubtrair.setFont(fontePadrao);
        botaoSubtrair.setBackground(new Color(255, 99, 71)); // Vermelho
        botaoSubtrair.setForeground(Color.WHITE);
        painelBotoes.add(botaoSubtrair);

        botaoMultiplicar = new JButton("✖ Multiplicar");
        botaoMultiplicar.setFont(fontePadrao);
        botaoMultiplicar.setBackground(new Color(34, 139, 34)); // Verde
        botaoMultiplicar.setForeground(Color.WHITE);
        painelBotoes.add(botaoMultiplicar);

        botaoDividir = new JButton("➗ Dividir");
        botaoDividir.setFont(fontePadrao);
        botaoDividir.setBackground(new Color(255, 165, 0)); // Laranja
        botaoDividir.setForeground(Color.WHITE);
        painelBotoes.add(botaoDividir);

        painel.add(painelBotoes);

        // Espaço entre os botões e o campo de resultado
        painel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Campo de Resultado
        campoResultado = new JTextField(20);
        campoResultado.setFont(fontePadrao);
        campoResultado.setHorizontalAlignment(JTextField.CENTER);
        campoResultado.setEditable(false);
        campoResultado.setBackground(new Color(230, 240, 250));
        campoResultado.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237)));
        painel.add(campoResultado);

        // Evento do botão Somar
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

        // Evento do botão Subtrair
        botaoSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(campoNumero1.getText().trim());
                    int num2 = Integer.parseInt(campoNumero2.getText().trim());
                    int resultado = num1 - num2;
                    campoResultado.setForeground(new Color(0, 128, 0));
                    campoResultado.setText("✅ Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    campoResultado.setForeground(Color.RED);
                    campoResultado.setText("❌ Por favor, digite apenas números.");
                }
            }
        });

        // Evento do botão Multiplicar
        botaoMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(campoNumero1.getText().trim());
                    int num2 = Integer.parseInt(campoNumero2.getText().trim());
                    int resultado = num1 * num2;
                    campoResultado.setForeground(new Color(0, 128, 0));
                    campoResultado.setText("✅ Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    campoResultado.setForeground(Color.RED);
                    campoResultado.setText("❌ Por favor, digite apenas números.");
                }
            }
        });

        // Evento do botão Dividir
        botaoDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(campoNumero1.getText().trim());
                    int num2 = Integer.parseInt(campoNumero2.getText().trim());
                    if (num2 == 0) {
                        campoResultado.setForeground(Color.RED);
                        campoResultado.setText("❌ Divisão por zero não permitida.");
                    } else {
                        double resultado = (double) num1 / num2;
                        campoResultado.setForeground(new Color(0, 128, 0));
                        campoResultado.setText("✅ Resultado: " + resultado);
                    }
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
