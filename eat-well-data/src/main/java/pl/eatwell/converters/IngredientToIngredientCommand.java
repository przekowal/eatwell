package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import pl.eatwell.commands.IngredientCommand;
import pl.eatwell.model.Ingredient;

public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final MeasureToMeasureCommand measureConverter;
    private final FoodToFoodCommand foodConverter;

    public IngredientToIngredientCommand(MeasureToMeasureCommand measureConverter, FoodToFoodCommand foodConverter) {
        this.measureConverter = measureConverter;
        this.foodConverter = foodConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source == null){
            return null;
        }
        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setFoodCommand(foodConverter.convert(source.getFood()));
        ingredientCommand.setMeasure(measureConverter.convert(source.getMeasure()));

        return ingredientCommand;
    }
}
