package frost.countermobil.Polygon.DAO.Local;

import frost.countermobil.Polygon.DAO.UserDAO;
import frost.countermobil.Polygon.models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAOLocal implements UserDAO {
    static List<User> users = new ArrayList<>();
    static int userId = 1;

    public synchronized void registerUser(User user) {
        user.setId(userId);
        users.add(user);
        userId++;
    }

    public int getUserId() {
        return userId;
    }

    public User recoverUser(String userName) {
        User target = null;
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                target = user;
                break;
            }
        }
        return target;
    }

}
