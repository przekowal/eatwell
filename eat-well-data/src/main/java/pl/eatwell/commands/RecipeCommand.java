package pl.eatwell.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.eatwell.model.Difficulty;
import pl.eatwell.model.Ingredient;
import pl.eatwell.model.RecipeType;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String name;
    private String description;
    private List<IngredientCommand> ingredients = new ArrayList<>();
    private Integer preparationTime;
    private Integer cookingTime;
    private String sourceUrl;
    private String imageUrl;
    private Set<RecipeTypeCommand> recipeTypes;
    private Difficulty difficulty;
    private DirectionsCommand directions;
    private UserCommand user;
}
