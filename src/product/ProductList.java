package product;

import java.util.HashSet;
import java.util.Set;

public class ProductList {

    Set<Product> products = new HashSet<>();


    public void add(Product product) {
        if (products.contains(product)) {
            throw new RuntimeException("Такой продукт уже имеется");
        } else {
            products.add(product);
        }
    }

    public void remove(Product product) {
        if (products.remove(product)) {
            System.out.println("Продукт " + product.getName() + " удален");
        }
    }

    @Override
    public String toString() {
        return "Список продукотов: " + "\n" + products;
    }
}