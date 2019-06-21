package pl.eatwell.services;

import pl.eatwell.model.User;

public interface UserService extends CrudService<User, Long> {

    public User findByNickname(String nickName);
}
