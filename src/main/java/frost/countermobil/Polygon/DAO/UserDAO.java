package frost.countermobil.Polygon.DAO;

import frost.countermobil.Polygon.models.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {

    void registerUser(User user);

    User recoverUser(String userName);
}
