package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import pl.eatwell.commands.FoodCategoryCommand;
import pl.eatwell.model.FoodCategory;

public class FoodCategoryToFoodCategoryCommand implements Converter<FoodCategory, FoodCategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public FoodCategoryCommand convert(FoodCategory source) {

        if(source == null){
            return null;
        }

        final FoodCategoryCommand foodCategoryCommand = new FoodCategoryCommand();
        foodCategoryCommand.setId(source.getId());
        foodCategoryCommand.setCategory(source.getCategory());

        return foodCategoryCommand;
    }
}
