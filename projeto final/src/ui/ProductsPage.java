package ui;

import classes.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends JFrame {
    private List<Product> productList;

    public ProductsPage(List<Product> productList) {
        this.productList = new ArrayList<>();
        setTitle("Vitrine de Produtos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBackground(new Color(240, 240, 240));

        for (Product product : productList) {
            JPanel productCard = createProductCard(product);
            panel.add(productCard);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton goToCart = new JButton("Ir para o Carrinho");
        goToCart.setFont(new Font("Arial", Font.PLAIN, 14));
        goToCart.setBackground(new Color(75, 110, 175));
        goToCart.setForeground(Color.WHITE);
        goToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                goToCart();
            }
        });

        getContentPane().add(goToCart, BorderLayout.SOUTH);

    }

    private JPanel createProductCard(Product product) {
        JPanel productCard = new JPanel(new BorderLayout());
        productCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        productCard.setBackground(Color.WHITE);
        productCard.setPreferredSize(new Dimension(350, 250));

        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productCard.add(nameLabel, BorderLayout.NORTH);

        JLabel imageLabel = new JLabel(product.getDescription());
        imageLabel.setPreferredSize(new Dimension(150, 150));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productCard.add(imageLabel, BorderLayout.CENTER);

        JLabel priceLabel = new JLabel(String.format("R$ %.2f", product.getPrice()));
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productCard.add(priceLabel, BorderLayout.SOUTH);

        JButton addToCartButton = new JButton("Adicionar ao Carrinho");
        addToCartButton.setFont(new Font("Arial", Font.PLAIN, 14));
        addToCartButton.setBackground(new Color(75, 110, 175));
        addToCartButton.setForeground(Color.WHITE);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addToCart(product);
            }
        });
        productCard.add(addToCartButton, BorderLayout.SOUTH);

        return productCard;
    }

    private void addToCart(Product product) {
        this.productList.add(product);
    }

    private void goToCart() {
        if (this.productList == null || this.productList.size() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione algum produto para acessar o carrinho.");
        } else {

            CartPage cartPage = new CartPage(this.productList);
            cartPage.setVisible(true);
        }
    }

}
