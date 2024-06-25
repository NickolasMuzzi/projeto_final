package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import classes.Product;

public class CartPage extends JFrame {

    public CartPage(List<Product> productList) {
        setTitle("Carrinho de Compras");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 240, 240));

        JPanel productsPanel = new JPanel();
        productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(productsPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        for (Product product : productList) {
            JPanel productPanel = createProductPanel(product);
            productsPanel.add(productPanel);
            productsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.setBackground(Color.WHITE);
        JLabel totalLabel = new JLabel("Total: R$ " + calculateTotal(productList));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalPanel.add(totalLabel);

        JButton goToPaymentButton = new JButton("Ir para Pagamento");
        goToPaymentButton.setFont(new Font("Arial", Font.BOLD, 16));
        goToPaymentButton.setBackground(new Color(75, 110, 175));
        goToPaymentButton.setForeground(Color.WHITE);
        totalPanel.add(goToPaymentButton);

        JButton goToVitrineButton = new JButton("Voltar para Vitrine");
        goToVitrineButton.setFont(new Font("Arial", Font.BOLD, 16));
        goToVitrineButton.setBackground(new Color(75, 110, 175));
        goToVitrineButton.setForeground(Color.WHITE);
        totalPanel.add(goToVitrineButton);

        panel.add(totalPanel, BorderLayout.SOUTH);

        goToPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> ids = new ArrayList<Integer>();
                for (Product prod : productList) {
                    ids.add(prod.getId());
                }
                PaymentPage paymentPage = new PaymentPage(calculateTotal(productList), ids);
            }
        });

        goToVitrineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }

    private JPanel createProductPanel(Product product) {
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        productPanel.setBackground(Color.WHITE);
        productPanel.setPreferredSize(new Dimension(600, 100));

        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        productPanel.add(nameLabel, BorderLayout.WEST);

        JLabel priceLabel = new JLabel("  " + product.getPrice().toString());
        productPanel.add(priceLabel, BorderLayout.CENTER);

        return productPanel;
    }

    private double calculateTotal(List<Product> productList) {

        Double total = 0.0;
        for (Product prod : productList) {
            total += prod.getPrice();
        }

        return total;
    }

}
