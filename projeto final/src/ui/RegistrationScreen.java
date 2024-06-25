package ui;

import classes.NextPage;
import classes.User;
import infra.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationScreen extends JFrame {

  private String username;
  private String password;
  private String confirmPassword;

  public RegistrationScreen(NextPage next) {

    setTitle("Tela de Registro");
    setSize(800, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setExtendedState(JFrame.MAXIMIZED_BOTH);

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
    userLabel.setForeground(new Color(255, 255, 255));
    userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
    gbc.insets = new Insets(5, 10, 5, 10);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    panel.add(userLabel, gbc);

    JTextField userText = new JTextField(30);
    userText.setPreferredSize(new Dimension(200, 25));
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    panel.add(userText, gbc);

    JLabel passwordLabel = new JLabel("Senha:");
    passwordLabel.setForeground(new Color(255, 255, 255));
    passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    panel.add(passwordLabel, gbc);

    JPasswordField passwordText = new JPasswordField(30);
    passwordText.setPreferredSize(new Dimension(200, 25));
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    panel.add(passwordText, gbc);

    JLabel confirmPasswordLabel = new JLabel("Confirmar Senha:");
    confirmPasswordLabel.setForeground(new Color(255, 255, 255));
    confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    panel.add(confirmPasswordLabel, gbc);

    JPasswordField confirmPasswordText = new JPasswordField(30);
    confirmPasswordText.setPreferredSize(new Dimension(200, 25));
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
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

    JButton goToLogin = new JButton("Já possuo uma conta");
    goToLogin.setFont(new Font("Arial", Font.BOLD, 16));
    goToLogin.setBackground(new Color(75, 110, 175));
    goToLogin.setForeground(Color.WHITE);
    gbc.insets = new Insets(15, 10, 10, 10);
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 2;
    panel.add(goToLogin, gbc);

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
                  JOptionPane.ERROR_MESSAGE);
            } else {
              User newUser = new User(username, password);
              Register registerService = new Register();
              try {
                registerService.register(newUser);
                next.setVisible(true);
                hidePage();
              } catch (Exception error) {
                error.printStackTrace();
              }
            }
          }
        });
    goToLogin.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            next.setVisible(true);
            hidePage();
          }
        });

  }

  public void showPanel(boolean visible) {
    setVisible(visible);
  }

  public void hidePage() {
    setVisible(false);
  }

}
