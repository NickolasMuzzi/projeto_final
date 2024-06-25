import classes.Product;
import infra.Products;
import ui.LoginScreen;
import ui.ProductsPage;
import ui.RegistrationScreen;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Products productService = new Products();
        List<Product> productList = new ArrayList<>();
        try {
            productList = productService.getProducts();
        } catch (Exception err) {
            err.printStackTrace();

        }
        ProductsPage productsPage = new ProductsPage(productList);
        LoginScreen loginPage = new LoginScreen(productsPage);
        RegistrationScreen registerPage = new RegistrationScreen((show) -> loginPage.showPanel(show));
        registerPage.showPanel(true);

    }
}
