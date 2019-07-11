package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import pl.eatwell.commands.FoodCommand;
import pl.eatwell.model.Food;

public class FoodCommandToFood implements Converter<FoodCommand, Food> {

    private final MeasureCommandToMeasure measureConverter;
    private final NutritionCommandToNutrition nutritionConverter;
    private final FoodCategoryCommandToFoodCategory foodCategoryConverter;

    public FoodCommandToFood(MeasureCommandToMeasure measureConverter,
                             NutritionCommandToNutrition nutritionCommandToNutrition,
                             FoodCategoryCommandToFoodCategory foodCategoryConverter1) {
        this.measureConverter = measureConverter;
        this.nutritionConverter = nutritionCommandToNutrition;
        this.foodCategoryConverter = foodCategoryConverter1;
    }

    @Synchronized
    @Nullable
    @Override
    public Food convert(FoodCommand source) {
        if(source == null){
            return null;
        }

        final Food food = new Food();
        food.setId(source.getId());
        food.setName(source.getName());
        food.setDescription(source.getDescription());
        food.setGlutenFree(source.getGlutenFree());
        if(source.getMeasures() != null && source.getMeasures().size() > 0){
           source.getMeasures().forEach(measureCommand -> food.getMeasures().add(measureConverter.convert(measureCommand)));
        }

        if(source.getNutritions() != null && source.getNutritions().size() > 0){
            source.getNutritions().forEach(nutritionCommand -> food.getNutritions().add(nutritionConverter.convert(nutritionCommand)));
        }

        food.setFoodCategory(foodCategoryConverter.convert(source.getFoodCategory()));

        return food;
    }
}
