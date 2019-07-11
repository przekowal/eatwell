package pl.eatwell.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {
    private Long id;
    private String firstName;
    private String lastName;
    private String nickname;
}
