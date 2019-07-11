package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import pl.eatwell.commands.UserCommand;
import pl.eatwell.model.User;

public class UserCommandToUser implements Converter<UserCommand, User> {

    @Synchronized
    @Nullable
    @Override
    public User convert(UserCommand source) {
        if(source == null){
            return null;
        }

        User user = new User();
        user.setId(source.getId());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setNickname(source.getNickname());

        return user;
    }
}
