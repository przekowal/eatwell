package pl.eatwell.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MeasureCommand {
    private Long id;
    private String description;
    private Double amount;
    private Integer weightInGrams;
}
