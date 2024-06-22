package interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegistrationScreen extends JFrame {

  // Variáveis para armazenar o texto dos campos
  private String username;
  private String password;
  private String confirmPassword;

  public RegistrationScreen() {
    setTitle("Tela de Registro");
    setSize(700, 300); // Ajustei o tamanho da janela para acomodar os campos maiores
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(new Color(60, 63, 65));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel titleLabel = new JLabel("Registro", JLabel.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(new Color(187, 187, 187));
    gbc.insets = new Insets(10, 10, 20, 10);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    panel.add(titleLabel, gbc);

    JLabel userLabel = new JLabel("Usuário:");
    userLabel.setForeground(new Color(187, 187, 187));
    userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
    gbc.insets = new Insets(5, 10, 5, 10);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    panel.add(userLabel, gbc);

    JTextField userText = new JTextField(30); // Ajustei a largura do campo
    userText.setPreferredSize(new Dimension(200, 25)); // Definição de tamanho preferido
    gbc.gridx = 1;
    gbc.gridy = 1;
    panel.add(userText, gbc);

    JLabel passwordLabel = new JLabel("Senha:");
    passwordLabel.setForeground(new Color(187, 187, 187));
    passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
    gbc.gridx = 0;
    gbc.gridy = 2;
    panel.add(passwordLabel, gbc);

    JPasswordField passwordText = new JPasswordField(30); // Ajustei a largura do campo
    passwordText.setPreferredSize(new Dimension(200, 25)); // Definição de tamanho preferido
    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(passwordText, gbc);

    JLabel confirmPasswordLabel = new JLabel("Confirmar Senha:");
    confirmPasswordLabel.setForeground(new Color(187, 187, 187));
    confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
    gbc.gridx = 0;
    gbc.gridy = 3;
    panel.add(confirmPasswordLabel, gbc);

    JPasswordField confirmPasswordText = new JPasswordField(30); // Ajustei a largura do campo
    confirmPasswordText.setPreferredSize(new Dimension(200, 25)); // Definição de tamanho preferido
    gbc.gridx = 1;
    gbc.gridy = 3;
    panel.add(confirmPasswordText, gbc);

    JButton registerButton = new JButton("Registrar");
    registerButton.setFont(new Font("Arial", Font.BOLD, 16));
    registerButton.setBackground(new Color(75, 110, 175));
    registerButton.setForeground(Color.WHITE);
    gbc.insets = new Insets(15, 10, 10, 10);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    panel.add(registerButton, gbc);

    add(panel);

    registerButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          username = userText.getText();
          password = new String(passwordText.getPassword());
          confirmPassword = new String(confirmPasswordText.getPassword());

          if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(
              null,
              "As senhas não coincidem!",
              "Erro",
              JOptionPane.ERROR_MESSAGE
            );
          } else {
            JOptionPane.showMessageDialog(
              null,
              "Usuário: " + username +
              "\nSenha: " + password
            );
          }
        }
      }
    );

    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          new RegistrationScreen();
        }
      }
    );
  }
}
