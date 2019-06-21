package pl.eatwell.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eatwell.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByNickname(String lastName);
}
