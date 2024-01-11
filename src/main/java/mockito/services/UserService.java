package mockito.services;

import mockito.dao.UserDao;
import mockito.model.User;

public class UserService {
    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public boolean checkUserPresence(User user) throws Exception {
        User u = dao.getUserByUsername(user.getUsername());
        return u != null;
    }
}
