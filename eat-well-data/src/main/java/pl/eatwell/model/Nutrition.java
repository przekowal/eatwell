package pl.eatwell.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Objects;

@Entity
@EqualsAndHashCode(exclude = {"unitOfMeasure", "amount"})
@Data
public class Nutrition extends BaseEntity{

    private String name;
    //this is not Measure
    private String unitOfMeasure;
    private Float amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nutrition nutrition = (Nutrition) o;
        return name.equals(nutrition.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
