package pl.eatwell.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
@NoArgsConstructor
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String image;
    private String nickname;

    @OneToMany(mappedBy = "user")
    private Set<Recipe> recipes;

    @Builder
    public User(Long id, String firstName, String lastName, String image, String nickname, Set<Recipe> recipes) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.nickname = nickname;
        this.recipes = recipes;
    }
}
