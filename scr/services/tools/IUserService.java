package services.tools;

import model.user.User;
import java.util.List;

public interface IUserService {
    List<User> getUser();
    User getUserByID(int id);
}
