package pl.eatwell;

import pl.eatwell.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static pl.eatwell.FoodUtils.getFullListOfSixFoods;

public class RecipeUtils {

    private static List<Food> foods = getFullListOfSixFoods();

    public static List<Recipe> getListOf2Recipes(){

        List<Recipe> recipes = new ArrayList<>();

        Recipe recipe1 = new Recipe();
        recipe1.setName("Chicken with Fries");
        recipe1.setDescription("Fried chicken with chips");
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setImageUrl("recipe1.jpg");

        RecipeType recipeType1 = new RecipeType();
        recipeType1.setType("Main dish");
        recipe1.setRecipeTypes(new HashSet<>());
        recipe1.getRecipeTypes().add(recipeType1);

        User user1 = new User();
        user1.setFirstName("Marcin");
        user1.setLastName("Kowal");
        recipe1.setUser(user1);

        Ingredient ingredient1 = new Ingredient(foods.get(0), new Measure("pieces", 2f));
        ingredient1.getMeasure().setWeighInGrams(150);
        Ingredient ingredient2 =new Ingredient(foods.get(1), new Measure("grams", 200f));
        Ingredient ingredient3 = new Ingredient(foods.get(2), new Measure("grams", 300f));
        recipe1.addIngredient(ingredient1).addIngredient(ingredient2).addIngredient(ingredient3);
        recipes.add(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setName("Onion Soup");
        recipe2.setDescription("Tasty onion soup");
        recipe2.setDifficulty(Difficulty.EASY);
        recipe2.setImageUrl("recipe2.jpg");

        RecipeType recipeType2 = new RecipeType();
        recipeType2.setType("Soup");
        recipe2.setRecipeTypes(new HashSet<>());
        recipe2.getRecipeTypes().add(recipeType2);

        User user2 = new User();
        user2.setFirstName("Darek ");
        user2.setLastName("Mik");
        recipe2.setUser(user2);

        Ingredient ingredient4 = new Ingredient(foods.get(3), new Measure("mililiters", 120f));
        ingredient4.getMeasure().setWeighInGrams(120);
        Ingredient ingredient5 = new Ingredient(foods.get(4), new Measure("grams", 150f));
        Ingredient ingredient6 = new Ingredient(foods.get(5), new Measure("grams", 130f));
        recipe2.addIngredient(ingredient4).addIngredient(ingredient5).addIngredient(ingredient6);
        recipes.add(recipe2);

        return recipes;
    }
}
