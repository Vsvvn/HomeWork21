package product;

import java.util.HashSet;
import java.util.Set;

public class RecipesList {

    Set<Recipes> recipes = new HashSet<>();

    public Set<Recipes> getRecipes() {
        return recipes;
    }

    public void add(Recipes recipe) {
        if (this.recipes.contains(recipe)) {
            throw new RuntimeException("Такой рецепт уже имеется");
        } else {
            this.recipes.add(recipe);
        }
    }

    public void remove(Recipes recipes1) {
        if (recipes.remove(recipes1)) {
            System.out.println("Продукт " + recipes1.getRecipeName() + " удален");
        }
    }

    @Override
    public String toString() {
        return "Список рецептов: " + "\n" + recipes;
    }
}