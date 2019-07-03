package pl.eatwell.services.springDataJpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.eatwell.model.User;
import pl.eatwell.repositories.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserJpaServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserJpaService userJpaService;

    final static String NICKNAME = "Kowal";

    User returnedUser;

    @BeforeEach
    void setUp() {
        returnedUser = User.builder().id(1L).nickname(NICKNAME).build();
    }

    @Test
    void findByNickname() {
        when(userRepository.findByNickname(any())).thenReturn(returnedUser);

        User marcin = userJpaService.findByNickname(NICKNAME);

        assertEquals(NICKNAME, marcin.getNickname());
        verify(userRepository).findByNickname(any());
    }

    @Test
    void findAll() {
        Set<User> users = new HashSet<>();
        users.add(User.builder().id(1L).nickname("Kowal").build());
        users.add(User.builder().id(2L).nickname("Bet").build());

        when(userRepository.findAll()).thenReturn(users);

        Set<User> returnedUsers = userJpaService.findAll();

        assertEquals(2, returnedUsers.size());
        verify(userRepository).findAll();
    }

    @Test
    void findById() {

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(returnedUser));

        User foundUser = userJpaService.findById(1L);

        assertEquals(1L, foundUser.getId().longValue());
        verify(userRepository).findById(any());

    }

    @Test
    void save() {
        when(userRepository.save(any())).thenReturn(returnedUser);

        User savedUser = userJpaService.save(returnedUser);

        assertNotNull(savedUser);
        verify(userRepository).save(any());
    }

    @Test
    void delete() {
        userJpaService.delete(returnedUser);

        verify(userRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {

        userJpaService.deleteById(returnedUser.getId());

        verify(userRepository).deleteById(anyLong());
    }
}