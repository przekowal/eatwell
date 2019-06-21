package pl.eatwell.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class Directions extends BaseEntity {

    @Lob
    private String notes;

    //Recipe owns this
    @OneToOne
    private Recipe recipe;

    public Directions(String notes){
        this.notes = notes;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Directions;
    }

}
