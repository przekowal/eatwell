package pl.eatwell.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String image;
    private String nickname;

    @OneToMany(mappedBy = "user")
    private Set<Recipe> recipes;

}
