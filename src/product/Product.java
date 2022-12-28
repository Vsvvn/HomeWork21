package product;

import java.util.Objects;
import java.util.regex.Pattern;

public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);

        if (!checkName(name)) {
            throw new RuntimeException("Нужно ввести название продукта: " + getName() + " на русском языке. ");
        }
    }

    public void setName(String name) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new RuntimeException("Заполните карточку товара полностью");
        } else {
            this.name = name;
        }
    }

    public void setPrice(double price) {
        if (price == 0) {
            throw new RuntimeException("Заполните карточку товара полностью");
        } else {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean checkName(String name) {
        if (name == null
                || name.isBlank()
                || name.isEmpty()) {
            return false;
        }
        return Pattern.matches("[а-яА-Я]*$", name);
    }

    public void setQuantity(int quantity) {
        if (quantity == 0) {
            throw new RuntimeException("Заполните карточку товара полностью");
        } else {
            this.quantity = quantity;
        }
    }

    @Override
    public String toString() {
        return "Название продукта " + name + ", цена " + price +
                ", количество " + quantity +
                "." + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
