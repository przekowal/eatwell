package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.eatwell.commands.FoodCategoryCommand;
import pl.eatwell.model.FoodCategory;

@Component
public class FoodCategoryCommandToFoodCategory implements Converter<FoodCategoryCommand, FoodCategory> {

    @Nullable
    @Synchronized
    @Override
    public FoodCategory convert(FoodCategoryCommand source) {
        if(source == null){
            return null;
        }

        final FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(source.getId());
        foodCategory.setCategory(source.getCategory());

        return foodCategory;
    }
}
