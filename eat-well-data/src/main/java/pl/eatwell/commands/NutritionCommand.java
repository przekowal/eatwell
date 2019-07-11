package pl.eatwell.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NutritionCommand {
    private Long id;
    private String name;
    private String unitOfMeasure;
    private Double amount;
}
