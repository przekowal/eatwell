package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.eatwell.commands.RecipeTypeCommand;
import pl.eatwell.model.RecipeType;

@Component
public class RecipeTypeToRecipeTypeCommand implements Converter<RecipeType, RecipeTypeCommand> {

    @Nullable
    @Synchronized
    @Override
    public RecipeTypeCommand convert(RecipeType source) {
        if(source == null){
            return null;
        }

        final RecipeTypeCommand recipeTypeCommand = new RecipeTypeCommand();
        recipeTypeCommand.setId(source.getId());
        recipeTypeCommand.setType(source.getType());

        return recipeTypeCommand;
    }
}

