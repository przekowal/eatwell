package pl.eatwell.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.eatwell.model.*;
import pl.eatwell.services.FoodService;
import pl.eatwell.services.RecipeService;
import pl.eatwell.services.RecipeTypeService;
import pl.eatwell.services.UserService;

import java.util.ArrayList;

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

    private void load() {
        Food food1 = new Food();
        food1.setName("Onion");
        food1.setDescription("White Onion");
        food1.setCategory("Vegetable");
        foodService.save(food1);

        Food food2 = new Food();
        food2.setName("Chicken");
        food2.setDescription("Whole Chicken");
        food2.setCategory("Meat");
        foodService.save(food2);

        Food food3 = new Food();
        food3.setName("Potato");
        food3.setDescription("White potato");
        food3.setCategory("Vegetable");
        foodService.save(food3);

        Food food4 = new Food();
        food4.setName("Milk 2%");
        food4.setDescription("Semi skimmed milk");
        food4.setCategory("Diary");
        foodService.save(food4);

        Food food5 = new Food();
        food5.setName("Yellow Cheese");
        food5.setDescription("Gouda Cheese");
        food5.setCategory("Diary");
        foodService.save(food5);

        Food food6 = new Food();
        food6.setName("Butter");
        food6.setDescription("Natural Butter");
        food6.setCategory("Diary");
        foodService.save(food6);

        Recipe recipe1 = new Recipe();
        recipe1.setName("Chicken with Fries");
        recipe1.setDescription("Fried chicken with chips");
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setImageUrl("recipe1.jpg");

        RecipeType recipeType1 = new RecipeType();
        recipeType1.setType("Main dish");
        recipeTypeService.save(recipeType1);
        recipe1.setRecipeType(recipeType1);

        User user1 = new User();
        user1.setFirstName("Marcin");
        user1.setLastName("Kowal");
        userService.save(user1);
        recipe1.setUser(user1);

        recipe1.setIngredients(new ArrayList<>());
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setFood(food1);
        ingredient1.setWeightInGrams(150);
        recipe1.getIngredients().add(ingredient1);
        Ingredient ingredient2 =new Ingredient();
        ingredient2.setFood(food2);
        ingredient2.setWeightInGrams(200);
        recipe1.getIngredients().add(ingredient2);
        Ingredient ingredient3 = new Ingredient();
        ingredient3.setFood(food3);
        ingredient3.setWeightInGrams(300);
        recipe1.getIngredients().add(ingredient3);
        recipeService.save(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setName("Onion Soup");
        recipe2.setDescription("Tasty onion soup");
        recipe2.setDifficulty(Difficulty.EASY);
        recipe2.setImageUrl("recipe2.jpg");

        RecipeType recipeType2 = new RecipeType();
        recipeType2.setType("Soup");
        recipeTypeService.save(recipeType2);
        recipe2.setRecipeType(recipeType2);

        User user2 = new User();
        user2.setFirstName("Darek ");
        user2.setLastName("Mik");
        userService.save(user2);
        recipe2.setUser(user2);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setFood(food4);
        ingredient4.setWeightInGrams(120);
        recipe2.setIngredients(new ArrayList<>());
        recipe2.getIngredients().add(ingredient4);
        Ingredient ingredient5 = new Ingredient();
        ingredient5.setFood(food5);
        ingredient5.setWeightInGrams(240);
        recipe2.getIngredients().add(ingredient5);
        Ingredient ingredient6 = new Ingredient();
        ingredient6.setFood(food6);
        ingredient6.setWeightInGrams(320);
        recipe2.getIngredients().add(ingredient6);
        recipeService.save(recipe2);

        System.out.println("Loaded recipes and Foods ...");
    }
}
