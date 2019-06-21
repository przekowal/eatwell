package pl.eatwell.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class RecipeType extends BaseEntity {

    private String type;

    @ManyToMany(mappedBy = "recipeTypes")
    private Set<Recipe> recipes;

}
