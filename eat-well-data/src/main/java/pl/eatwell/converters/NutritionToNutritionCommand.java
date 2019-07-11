package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import pl.eatwell.commands.NutritionCommand;
import pl.eatwell.model.Nutrition;

public class NutritionToNutritionCommand implements Converter<Nutrition, NutritionCommand> {
    @Synchronized
    @Nullable
    @Override
    public NutritionCommand convert(Nutrition source) {
        if(source == null){
            return null;
        }
        final NutritionCommand nutritionCommand = new NutritionCommand();
        nutritionCommand.setId(source.getId());
        nutritionCommand.setName(source.getName());
        nutritionCommand.setAmount(source.getAmount());
        nutritionCommand.setUnitOfMeasure(source.getUnitOfMeasure());

        return nutritionCommand;
    }
}
