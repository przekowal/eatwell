package pl.eatwell.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class FoodCommand {
    private Long id;
    private String name;
    private String description;
    private Boolean glutenFree;
    private Set<MeasureCommand> measures;
    private Set<NutritionCommand> nutritions;
    private FoodCategoryCommand foodCategory;



}
