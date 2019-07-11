package pl.eatwell.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeTypeCommand {
    private Long id;
    private String type;
}
