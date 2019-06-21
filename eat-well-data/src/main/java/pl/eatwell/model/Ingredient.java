package pl.eatwell.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(exclude = {"nutritions"})
@NoArgsConstructor
@Entity
public class Ingredient extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private Measure measure;

    @OneToOne
    private Food food;

    @Transient
    private Map<Nutrition, Float> nutritions = new HashMap<>();

    @ManyToOne
    private Recipe recipe;

    public Ingredient(Food food, Measure measure){
        this.food = food;
        this.measure = measure;
    }

    //TODO check, move to service, when loaded calculate or read from db? or leave
    public void calculateNutrition(){
        this.food.getNutritions().forEach((nutrition) -> {
            this.nutritions.put(nutrition, nutrition.getAmount() * this.measure.getWeighInGrams() / 100);
        });
    }

}
