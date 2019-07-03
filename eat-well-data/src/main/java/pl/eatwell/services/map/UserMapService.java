package pl.eatwell.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.eatwell.model.User;
import pl.eatwell.services.UserService;

import java.util.Set;

@Service
@Profile(("default, map"))
public class UserMapService extends AbstractMapService<User, Long> implements UserService {

    @Override
    public User findByNickname(String nickName) {
        return this.findAll()
                .stream()
                .filter(user -> user.getNickname().equalsIgnoreCase(nickName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<User> findAll() {
        return super.findAll();
    }

    @Override
    public User findById(Long id) {
        return super.findById(id);
    }

    @Override
    public User save(User object) {
        return super.save(object);
    }

    @Override
    public void delete(User object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
