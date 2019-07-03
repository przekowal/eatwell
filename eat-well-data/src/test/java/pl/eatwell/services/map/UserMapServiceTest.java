package pl.eatwell.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.eatwell.model.User;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserMapServiceTest {

    UserMapService userMapService;
    final Long userId = 1L;
    final String nickname = "Marcin";

    @BeforeEach
    void setUp() {
        userMapService = new UserMapService();
        userMapService.save(User.builder().id(userId).nickname(nickname).build());

    }

    @Test
    void findByNickname() {
        User user = userMapService.findByNickname(nickname);
        assertEquals("Marcin", user.getNickname());

    }

    @Test
    void findAll() {
        Set<User> users = userMapService.findAll();
        assertEquals(1, users.size());
    }

    @Test
    void findById() {
        User user = userMapService.findById(userId);
        assertEquals(userId, user.getId());
    }

    @Test
    void save() {
        User user2 = User.builder().id(2L).build();
        User savedUser =userMapService.save(user2);
        assertEquals(2L, savedUser.getId().longValue());


    }

    @Test
    void delete() {
        userMapService.delete(User.builder().id(userId).nickname(nickname).build());
        assertEquals(0, userMapService.findAll().size());
    }

    @Test
    void deleteById() {
        userMapService.deleteById(userId);
        assertEquals(0, userMapService.findAll().size());
    }
}