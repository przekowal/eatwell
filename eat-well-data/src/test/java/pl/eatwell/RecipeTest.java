package pl.eatwell;


import org.junit.Before;
import org.junit.Test;
import pl.eatwell.model.Ingredient;
import pl.eatwell.model.Nutrition;
import pl.eatwell.model.Recipe;

import java.util.List;

import static org.junit.Assert.*;


public class RecipeTest {


    private List<Recipe> recipes;

    @Before
    public void setup(){
        this.recipes = RecipeUtilsTest.getListOf2Recipes();
    }

    @Test
    public void GivenNutritionIngredientsRecipeNutritionValueShoudSumUp(){
        Recipe recipe = recipes.get(0);
        Nutrition protein = new Nutrition();
        protein.setName("protein");
        //sum proteins to 195
        recipe.calculateNutrition();
        recipe.getNutritions().forEach((k, v) -> System.out.println(k.getName() + ": " + v));
        assertEquals("Protein should calculate to 195", 195, recipe.getNutritions().get(protein).intValue());
    }

    @Test
    public void GivenWeighInGramsIngredientNutritionShouldCalculate(){
        Recipe recipe = recipes.get(0);
        Ingredient ingredient = recipe.getIngredients().get(0);
        //Protein  30g
        Nutrition protein = new Nutrition();
        protein.setName("protein");
        ingredient.getMeasure().setWeighInGrams(150);
        ingredient.calculateNutrition();
        ingredient.getNutritions().forEach((k, v) -> System.out.println(k.getName() + ": " + v));
        assertEquals("Protein should calculate to 45", 45, ingredient.getNutritions().get(protein).intValue());
    }

    @Test
    public void listShouldContain2Recipes(){

        assertEquals("Sould be 2 recipes", 2, recipes.size());
    }


    public static void loadData(){

    }
}
