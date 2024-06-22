package interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginScreen extends JFrame {

  // Variáveis para armazenar o texto dos campos
  private String username;
  private String password;

  public LoginScreen() {
    setTitle("Tela de Login");
    setSize(400, 250);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(new Color(60, 63, 65));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel titleLabel = new JLabel("Login", JLabel.CENTER);
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

    JTextField userText = new JTextField(20);
    gbc.gridx = 1;
    gbc.gridy = 1;
    panel.add(userText, gbc);

    JLabel passwordLabel = new JLabel("Senha:");
    passwordLabel.setForeground(new Color(187, 187, 187));
    passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
    gbc.gridx = 0;
    gbc.gridy = 2;
    panel.add(passwordLabel, gbc);

    JPasswordField passwordText = new JPasswordField(20);
    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(passwordText, gbc);

    JButton loginButton = new JButton("Login");
    loginButton.setFont(new Font("Arial", Font.BOLD, 16));
    loginButton.setBackground(new Color(75, 110, 175));
    loginButton.setForeground(Color.WHITE);
    gbc.insets = new Insets(15, 10, 10, 10);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 2;
    panel.add(loginButton, gbc);

    add(panel);

    loginButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          username = userText.getText();
          password = new String(passwordText.getPassword());

          JOptionPane.showMessageDialog(
            null,
            "Usuário: " + username + "\nSenha: " + password
          );
        }
      }
    );

    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          new LoginScreen();
        }
      }
    );
  }
}
