package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.eatwell.commands.IngredientCommand;
import pl.eatwell.model.Ingredient;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final FoodCommandToFood foodConverter;
    private final MeasureCommandToMeasure measureConverter;

    public IngredientCommandToIngredient(FoodCommandToFood foodConverter, MeasureCommandToMeasure measureConverter) {
        this.foodConverter = foodConverter;
        this.measureConverter = measureConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null){
            return null;
        }
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setFood(foodConverter.convert(source.getFoodCommand()));
        ingredient.setMeasure(measureConverter.convert(source.getMeasure()));
        return ingredient;
    }
}
