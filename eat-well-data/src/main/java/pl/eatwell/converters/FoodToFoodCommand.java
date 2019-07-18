package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.eatwell.commands.FoodCommand;
import pl.eatwell.model.Food;

@Component
public class FoodToFoodCommand implements Converter<Food, FoodCommand> {

    private final MeasureToMeasureCommand measureConverter;
    private final NutritionToNutritionCommand nutritionConverter;
    private final FoodCategoryToFoodCategoryCommand foodCategoryConverter;

    public FoodToFoodCommand(MeasureToMeasureCommand measureConverter,
                             NutritionToNutritionCommand nutritionConverter,
                             FoodCategoryCommandToFoodCategory foodCategoryConverter, FoodCategoryToFoodCategoryCommand foodCategoryConverter1) {
        this.measureConverter = measureConverter;
        this.nutritionConverter = nutritionConverter;
        this.foodCategoryConverter = foodCategoryConverter1;
    }

    @Override
    @Synchronized
    @Nullable
    public FoodCommand convert(Food source) {
        if(source == null){
            return null;
        }
        final FoodCommand foodCommand = new FoodCommand();
        foodCommand.setId(source.getId());
        foodCommand.setName(source.getName());
        foodCommand.setDescription(source.getDescription());
        foodCommand.setGlutenFree(source.getGlutenFree());
        if(source.getMeasures() != null && source.getMeasures().size() > 0){
            source.getMeasures()
                    .forEach(measure -> foodCommand.getMeasures().add(measureConverter.convert(measure)));
        }
        if(source.getNutritions() != null && source.getNutritions().size() > 0){
            source.getNutritions()
                    .forEach(nutrition -> foodCommand.getNutritions().add(nutritionConverter.convert(nutrition)));
        }
        foodCommand.setFoodCategory(foodCategoryConverter.convert(source.getFoodCategory()));
        return foodCommand;
    }
}
