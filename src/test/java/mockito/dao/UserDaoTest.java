package mockito.dao;

import mockito.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private UserDao dao;

    @BeforeEach
    public void setUp() {
        this.dao = new UserDaoImpl();
    }

    @Test
    public void getUserByUsername_Should_Return_True() throws Exception {
        User remy = dao.getUserByUsername("remy@gmail.com");
        assertNotEquals(null, remy);
        assertEquals(remy.getUsername(), "remy@gmail.com");
    }

    @Test
    public void getUserByUsername_Null_User() throws Exception {
        User alex = dao.getUserByUsername("alex@gmail.com");
        assertNull(alex);
    }

    @Test
    public void findAllUsers_Contain() {
        List<User> allUsers = dao.findAllUsers();
        assertThat(allUsers.get(2)).usingRecursiveComparison().isEqualTo((new User("remy@gmail.com", "ADMIN")));

        assertThat(allUsers).contains((new User("remy@gmail.com", "ADMIN")));
    }
}