package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import pl.eatwell.commands.UserCommand;
import pl.eatwell.model.User;

public class UserToUserCommand implements Converter<User, UserCommand> {

    @Synchronized
    @Nullable
    @Override
    public UserCommand convert(User source) {
        if(source == null){
            return null;
        }

        UserCommand userCommand = new UserCommand();
        userCommand.setFirstName(source.getFirstName());
        userCommand.setLastName(source.getLastName());
        userCommand.setNickname(source.getNickname());

        return userCommand;
    }
}
