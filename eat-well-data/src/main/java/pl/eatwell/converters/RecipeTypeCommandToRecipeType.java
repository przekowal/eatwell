package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import pl.eatwell.commands.RecipeTypeCommand;
import pl.eatwell.model.RecipeType;

public class RecipeTypeCommandToRecipeType implements Converter<RecipeTypeCommand, RecipeType> {
    @Synchronized
    @Nullable
    @Override
    public RecipeType convert(RecipeTypeCommand source) {

        if(source == null){
            return null;
        }

        final RecipeType recipeType = new RecipeType();
        recipeType.setId(source.getId());
        recipeType.setType(source.getType());
        return recipeType;
    }
}
