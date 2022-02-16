package service.iinterface;

import model.user.User;

public interface IUserService {
    User loginAdmin(String username, String password);

}
