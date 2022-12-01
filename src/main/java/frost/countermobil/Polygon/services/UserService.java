package frost.countermobil.Polygon.services;

import frost.countermobil.Polygon.DAO.Local.UserDAOLocal;
import frost.countermobil.Polygon.DAO.UserDAO;
import frost.countermobil.Polygon.models.User;

import java.util.List;

public class UserService {

    UserDAO userDAO = new UserDAOLocal();

    public void newUser(User user){
        userDAO.registerUser(user);
    }

    public User recoverUser(String userName){
        return userDAO.recoverUser(userName);
    }
}
