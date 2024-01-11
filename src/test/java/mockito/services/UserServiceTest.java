package mockito.services;

import mockito.dao.UserDao;
import mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class UserServiceTest {
    @Mock
    private UserDao dao;
    private UserService userService;
    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
        this.userService = new UserService(dao);
    }

    @Test
    public void checkUserPresence_Should_Return_True() throws Exception {
        given(dao.getUserByUsername("olga@gmail.com")).willReturn(new User("olga@gmail.com", null));

        boolean userExists = userService.checkUserPresence(new User("olga@gmail.com", null));
        assertTrue(userExists);
    }

    @Test
    public void checkUserPresence_Should_Return_False() throws Exception {
        given(dao.getUserByUsername("olga@gmail.com")).willReturn(null);

        boolean userExists = userService.checkUserPresence(new User("olga@gmail.com", null));
        assertFalse(userExists);

        //verify
        verify(dao).getUserByUsername("olga@gmail.com");
    }

    @Test
    public void checkUserPresence_Should_Throw_Exception() throws Exception {
        given(dao.getUserByUsername(anyString())).willThrow(Exception.class);
        Assertions.assertThrows(Exception.class, () -> userService.checkUserPresence(new User("olga@gmail.com", null)));
    }

    @Test
    public void testCaptor() throws Exception {
        given(dao.getUserByUsername(anyString())).willReturn(new User("olga@gmai.com", null));

        boolean b = userService.checkUserPresence(new User("olga@gmail.com", null));

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(dao).getUserByUsername(captor.capture());
        String argument = captor.getValue();
        assertThat(argument).isEqualTo("olga@gmail.com");
    }
}