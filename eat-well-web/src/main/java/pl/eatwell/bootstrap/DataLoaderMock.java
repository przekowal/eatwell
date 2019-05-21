package pl.eatwell.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.eatwell.model.Food;
import pl.eatwell.model.Recipe;
import pl.eatwell.services.FoodService;
import pl.eatwell.services.RecipeService;

@Component
public class DataLoaderMock implements CommandLineRunner {

    private final RecipeService recipeService;
    private final FoodService foodService;

    public DataLoaderMock(RecipeService recipeService, FoodService foodService) {
        this.recipeService = recipeService;
        this.foodService = foodService;
    }

    @Override
    public void run(String... args) throws Exception {

        Recipe recipe1 = new Recipe();
        recipe1.setName("Chicken with Fries");
        recipe1.setDescription("Fried chicken with chips");
        recipe1.setDifficulty("medium");
        recipeService.save(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setName("Onion Soup");
        recipe2.setDescription("Tasty onion soup");
        recipe2.setDifficulty("low");
        recipeService.save(recipe2);

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

        System.out.println("Loaded recipes and Foods ...");
    }
}
