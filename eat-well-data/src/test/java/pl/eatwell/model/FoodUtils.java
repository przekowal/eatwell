package pl.eatwell.model;

import pl.eatwell.model.Food;
import pl.eatwell.model.FoodCategory;
import pl.eatwell.model.Measure;
import pl.eatwell.model.Nutrition;

import java.util.*;

public class FoodUtils {

    //4
    public static List<Food> getFullListOfSixFoods(){
        return populateListOfFoodsWithNutrition();
    }

    //3
    private static List<Food> populateListOfFoodsWithNutrition(){

        Nutrition kCal = new Nutrition();
        kCal.setName("calories");
        kCal.setUnitOfMeasure("calories");
        kCal.setAmount(200.0);

        Nutrition protein = new Nutrition();
        protein.setName("protein");
        protein.setUnitOfMeasure("grams");
        protein.setAmount(30.0);

        Nutrition carb = new Nutrition();
        carb.setName("carb");
        carb.setUnitOfMeasure("grams");
        carb.setAmount(100.0);

        Nutrition fat = new Nutrition();
        fat.setName("fat");
        fat.setUnitOfMeasure("grams");
        fat.setAmount(40.0);

        List<Food> returnedFoods = pupulateListOfFoodsWith100GramMeasures();
        returnedFoods.forEach(f -> f.setNutritions(
                new HashSet<Nutrition>(Arrays.asList(kCal, protein, carb, fat))));

        return returnedFoods;
    }

    //2
    private static List<Food> pupulateListOfFoodsWith100GramMeasures(){

        Measure grams100 = new Measure();
        grams100.setDescription("grams");
        grams100.setWeighInGrams(100);

        List<Food> returnedFoods = loadListOfSixFoods();
        returnedFoods.forEach(f->f.setMeasures(new HashSet<Measure>(Arrays.asList(grams100))));

        return returnedFoods;
    }


    //1
    private static List<Food> loadListOfSixFoods(){

        List<Food> foods = new ArrayList<>();

        Food food1 = new Food();
        food1.setName("Onion");
        food1.setDescription("White Onion");
        food1.setFoodCategory(new FoodCategory("vegetable"));
        foods.add(food1);

        Food food2 = new Food();
        food2.setName("Chicken");
        food2.setDescription("Whole Chicken");
        food2.setFoodCategory(new FoodCategory("meat"));
        foods.add(food2);

        Food food3 = new Food();
        food3.setName("Potato");
        food3.setDescription("White potato");
        food3.setFoodCategory(new FoodCategory("vegetable"));
        foods.add(food3);

        Food food4 = new Food();
        food4.setName("Milk 2%");
        food4.setDescription("Semi skimmed milk");
        food4.setFoodCategory(new FoodCategory("diary"));
        foods.add(food4);

        Food food5 = new Food();
        food5.setName("Yellow Cheese");
        food5.setDescription("Gouda Cheese");
        food5.setFoodCategory(new FoodCategory("diary"));
        foods.add(food5);

        Food food6 = new Food();
        food6.setName("Butter");
        food6.setDescription("Natural Butter");
        food6.setFoodCategory(new FoodCategory("diary"));
        foods.add(food6);

        return foods;
    }
}
