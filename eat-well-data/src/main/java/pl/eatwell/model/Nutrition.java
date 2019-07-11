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
    private Double amount;
}
