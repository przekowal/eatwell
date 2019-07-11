package pl.eatwell.converters;

import org.springframework.core.convert.converter.Converter;
import pl.eatwell.commands.NutritionCommand;
import pl.eatwell.model.Nutrition;

public class NutritionCommandToNutrition implements Converter<NutritionCommand, Nutrition> {
    @Override
    public Nutrition convert(NutritionCommand source) {
        if(source == null){
            return null;
        }
        final Nutrition nutrition = new Nutrition();
        nutrition.setName(source.getName());
        nutrition.setUnitOfMeasure(source.getUnitOfMeasure());
        nutrition.setAmount(source.getAmount());
        return nutrition;
    }
}
