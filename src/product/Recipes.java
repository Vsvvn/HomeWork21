package product;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipes {

    ProductList productList;
    private String recipeName;
    private double sumAllProductsRecipe;

    public Recipes(ProductList productList, String recipeName) {
        setProductList(productList);
        setRecipeName(recipeName);
    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        if (productList == null) {
            System.out.println("Заполните список продуктов");
        } else {
            this.productList = productList;
        }
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        if (recipeName == null || recipeName.isBlank() || recipeName.isEmpty()) {
            throw new RuntimeException("Заполните карточку товара полностью");
        } else {
            this.recipeName = recipeName;
        }
    }

    public double sumAllProductsRecipe() {
        for (Product product : productList.products) {
            sumAllProductsRecipe += product.getPrice();
        }
        return sumAllProductsRecipe;
    }

    @Override
    public String toString() {
        return "Список продуктов в рецепте: " + recipeName + "," + "\n" + productList.products +
                ", сумма стоимости всех продуктов в рецепте " +
                sumAllProductsRecipe() + " руб." + "\n" + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return Objects.equals(recipeName, recipes.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName);
    }
}