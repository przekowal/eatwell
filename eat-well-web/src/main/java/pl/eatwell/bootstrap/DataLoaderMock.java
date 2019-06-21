package pl.eatwell.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.eatwell.model.*;
import pl.eatwell.services.FoodService;
import pl.eatwell.services.RecipeService;
import pl.eatwell.services.RecipeTypeService;
import pl.eatwell.services.UserService;

import java.util.*;

@Component
public class DataLoaderMock implements CommandLineRunner {

    private final RecipeService recipeService;
    private final FoodService foodService;
    private final RecipeTypeService recipeTypeService;
    private final UserService userService;

    public DataLoaderMock(RecipeService recipeService, FoodService foodService, RecipeTypeService recipeTypeService, UserService userService) {
        this.recipeService = recipeService;
        this.foodService = foodService;
        this.recipeTypeService = recipeTypeService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        int countRecipes = recipeService.findAll().size();
        if(countRecipes == 0){
            load();
        }
    }

    public void load() {
        Food food1 = new Food();
        food1.setName("Onion");
        food1.setDescription("White Onion");
        food1.setFoodCategory(new FoodCategory("vegetable"));
        foodService.save(food1);

        Food food2 = new Food();
        food2.setName("Chicken");
        food2.setDescription("Whole Chicken");
        food2.setFoodCategory(new FoodCategory("meat"));
        foodService.save(food2);

        Food food3 = new Food();
        food3.setName("Potato");
        food3.setDescription("White potato");
        food3.setFoodCategory(new FoodCategory("vegetable"));
        foodService.save(food3);

        Food food4 = new Food();
        food4.setName("Milk 2%");
        food4.setDescription("Semi skimmed milk");
        food4.setFoodCategory(new FoodCategory("diary"));
        foodService.save(food4);

        Food food5 = new Food();
        food5.setName("Yellow Cheese");
        food5.setDescription("Gouda Cheese");
        food5.setFoodCategory(new FoodCategory("diary"));
        foodService.save(food5);

        Food food6 = new Food();
        food6.setName("Butter");
        food6.setDescription("Natural Butter");
        food6.setFoodCategory(new FoodCategory("diary"));
        foodService.save(food6);

        List<Food> foods = new ArrayList<>(foodService.findAll());
        foods.forEach(f -> f.setNutritions(populateListOfFoodsWithNutrition()));

        Recipe recipe1 = new Recipe();
        recipe1.setName("Chicken with Fries");
        recipe1.setDescription("Fried chicken with chips");
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setImageUrl("recipe1.jpg");

        RecipeType recipeType1 = new RecipeType();
        recipeType1.setType("Main dish");
        recipeTypeService.save(recipeType1);
        recipe1.setRecipeTypes(new HashSet<>());
        recipe1.getRecipeTypes().add(recipeType1);

        User user1 = new User();
        user1.setFirstName("Marcin");
        user1.setLastName("Kowal");
        userService.save(user1);
        recipe1.setUser(user1);

        recipe1.setDirections(new Directions("Heat oil in a large skillet over medium heat and add chicken. Season with garlic powder, salt, pepper, and poultry seasoning. Cook until chicken is no longer pink inside and juices run clear, 10 to 12 minutes. Transfer cooked chicken to a large mixing bowl."));

        Ingredient ingredient1 = new Ingredient(foods.get(0), new Measure("pieces", 2f));
        ingredient1.getMeasure().setWeighInGrams(150);
        Ingredient ingredient2 =new Ingredient(foods.get(1), new Measure("grams", 200f));
        Ingredient ingredient3 = new Ingredient(foods.get(2), new Measure("grams", 300f));
        recipe1.addIngredient(ingredient1).addIngredient(ingredient2).addIngredient(ingredient3);
        recipeService.save(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setName("Onion Soup");
        recipe2.setDescription("Tasty onion soup");
        recipe2.setDifficulty(Difficulty.EASY);
        recipe2.setImageUrl("recipe2.jpg");

        RecipeType recipeType2 = new RecipeType();
        recipeType2.setType("Soup");
        recipeTypeService.save(recipeType2);
        recipe2.setRecipeTypes(new HashSet<>());
        recipe2.getRecipeTypes().add(recipeType2);

        User user2 = new User();
        user2.setFirstName("Darek ");
        user2.setLastName("Mik");
        userService.save(user2);
        recipe2.setUser(user2);

        recipe2.setDirections(new Directions("Add celery, red onion, and almonds to the bowl with the chicken. Toss in mayonnaise, lime juice, cumin, chili powder, and cilantro. Season with additional salt, pepper, and garlic powder. Add additional mayonnaise if salad seems too dry."));

        Ingredient ingredient4 = new Ingredient(foods.get(3), new Measure("mililiters", 120f));
        ingredient4.getMeasure().setWeighInGrams(120);
        Ingredient ingredient5 = new Ingredient(foods.get(4), new Measure("grams", 150f));
        Ingredient ingredient6 = new Ingredient(foods.get(5), new Measure("grams", 130f));
        recipe2.addIngredient(ingredient4).addIngredient(ingredient5).addIngredient(ingredient6);
        recipeService.save(recipe2);

        System.out.println("Loaded recipes and Foods ...");
    }

    private static Set<Nutrition> populateListOfFoodsWithNutrition(){

        Set<Nutrition> nuts = new HashSet<>();

        Nutrition kCal = new Nutrition();
        kCal.setName("calories");
        kCal.setUnitOfMeasure("calories");
        kCal.setAmount(200f);
        nuts.add(kCal);

        Nutrition protein = new Nutrition();
        protein.setName("protein");
        protein.setUnitOfMeasure("grams");
        protein.setAmount(30f);
        nuts.add(protein);

        Nutrition carb = new Nutrition();
        carb.setName("carb");
        carb.setUnitOfMeasure("grams");
        carb.setAmount(100f);
        nuts.add(carb);

        Nutrition fat = new Nutrition();
        fat.setName("fat");
        fat.setUnitOfMeasure("grams");
        fat.setAmount(40f);
        nuts.add(fat);

        return nuts;
    }
}
