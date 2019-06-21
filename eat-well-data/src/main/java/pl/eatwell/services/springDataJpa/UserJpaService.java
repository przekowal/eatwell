package pl.eatwell.services.springDataJpa;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.eatwell.model.User;
import pl.eatwell.repositories.UserRepository;
import pl.eatwell.services.UserService;

import java.security.acl.Owner;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class UserJpaService implements UserService {

    private final UserRepository userRepository;

    public UserJpaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByNickname(String nickName) {
        return userRepository.findByNickname(nickName);
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(Long aLong) {
        return userRepository.findById(aLong).orElse(null);
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }
}
