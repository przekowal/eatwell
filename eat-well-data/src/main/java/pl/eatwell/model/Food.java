package pl.eatwell.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"measures", "nutritions"})
@NoArgsConstructor
@Entity
public class Food extends BaseEntity {

    private String name;
    private String description;
    private Boolean glutenFree;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Measure> measures;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Nutrition> nutritions;

    @OneToOne(cascade = CascadeType.ALL)
    private FoodCategory foodCategory;

    @Builder
    public Food(Long id, String name, String description, Boolean glutenFree, Set<Measure> measures,
                Set<Nutrition> nutritions, FoodCategory foodCategory) {
        super(id);
        this.name = name;
        this.description = description;
        this.glutenFree = glutenFree;
        this.measures = measures;
        this.nutritions = nutritions;
        this.foodCategory = foodCategory;
    }
}
