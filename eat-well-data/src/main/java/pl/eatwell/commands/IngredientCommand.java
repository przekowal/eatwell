package pl.eatwell.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private FoodCommand foodCommand;
    private MeasureCommand measure;
}
