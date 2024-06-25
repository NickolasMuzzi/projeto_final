package ui;

import javax.swing.*;

import classes.Order;
import infra.Orders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PaymentPage extends JFrame {

    public PaymentPage(double totalValue, List<Integer> productsIds) {
        setTitle("Cadastro de Dados de Pagamento");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

    
        JLabel cardNumberLabel = new JLabel("Número do Cartão:");
        formPanel.add(cardNumberLabel, gbc);

        JTextField cardNumberField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(cardNumberField, gbc);

    
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel cardHolderLabel = new JLabel("Nome Impresso no Cartão:");
        formPanel.add(cardHolderLabel, gbc);

        JTextField cardHolderField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(cardHolderField, gbc);

    
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel expirationDateLabel = new JLabel("Data de Validade (MM/AAAA):");
        formPanel.add(expirationDateLabel, gbc);

        JTextField expirationDateField = new JTextField(7);
        gbc.gridx = 1;
        formPanel.add(expirationDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel cvvLabel = new JLabel("CVV:");
        formPanel.add(cvvLabel, gbc);

        JTextField cvvField = new JTextField(3);
        gbc.gridx = 1;
        formPanel.add(cvvField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel installmentsLabel = new JLabel("Número de Parcelas:");
        formPanel.add(installmentsLabel, gbc);

        String[] installmentsOptions = { "1x", "2x", "3x", "4x", "5x" };
        JComboBox<String> installmentsComboBox = new JComboBox<>(installmentsOptions);
        gbc.gridx = 1;
        formPanel.add(installmentsComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel installmentValueLabel = new JLabel("Valor Total:");
        formPanel.add(installmentValueLabel, gbc);

        JLabel installmentValue = new JLabel("R$ " + String.format("%.2f", totalValue));
        gbc.gridx = 1;
        formPanel.add(installmentValue, gbc);

    
        JButton finalizePaymentButton = new JButton("Finalizar Pagamento");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(finalizePaymentButton, gbc);

        panel.add(formPanel, BorderLayout.CENTER);

        JButton goToVitrineButton = new JButton("Voltar para Vitrine");
        goToVitrineButton.setFont(new Font("Arial", Font.BOLD, 16));
        goToVitrineButton.setBackground(new Color(75, 110, 175));
        goToVitrineButton.setForeground(Color.WHITE);
        panel.add(goToVitrineButton, BorderLayout.SOUTH);

        goToVitrineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        finalizePaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberField.getText();
                String cardHolderName = cardHolderField.getText();
                String expirationDate = expirationDateField.getText();
                String cvv = cvvField.getText();
                String selectedInstallments = (String) installmentsComboBox.getSelectedItem();
                int installments = Integer.parseInt(selectedInstallments.substring(0, 1));

                Order newOrder = new Order();
                newOrder.setCardNumber(cardNumber);
                newOrder.setCardHolderName(cardHolderName);
                newOrder.setExpirationDate(expirationDate);
                newOrder.setCvv(cvv);
                newOrder.setInstallments(installments);
                newOrder.setTotalAmount(totalValue);
                newOrder.setProductIds(productsIds);
                Orders order_service = new Orders();
                try {
                    order_service.new_order(newOrder);
                    JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso.");
                    System.exit(0);

                } catch (Exception error) {
                    error.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o pedido.");
                    System.exit(0);

                }
            }
        });

        add(panel);
        setVisible(true);
    }
}
