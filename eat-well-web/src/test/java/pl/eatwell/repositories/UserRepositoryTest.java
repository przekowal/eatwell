package pl.eatwell.repositories;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.eatwell.bootstrap.DataLoaderMock;
import pl.eatwell.model.User;
import pl.eatwell.services.FoodService;
import pl.eatwell.services.RecipeService;
import pl.eatwell.services.RecipeTypeService;
import pl.eatwell.services.UserService;

import java.util.Optional;
import static org.junit.Assert.*;


@DataJpaTest
@RunWith(SpringRunner.class)
@Profile("springdatajpa")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
   // @Ignore TODO set up integration tests
    public void findByNickname() {
        User user = userRepository.findByNickname("przekowal");
        assertEquals("przekowal", user.getNickname());
    }
}