package pl.eatwell.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
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
}
