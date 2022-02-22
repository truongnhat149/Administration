package services;

import model.user.User;
import services.tools.IUserService;
import utils.file.TextFileUtil;
import utils.json.JacksonParser;
import views.manager.UserView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements IUserService {
    private String path = "data/user.json";


    public List<User> getUser(){
        String jsonString = TextFileUtil.read(path);
        if(jsonString != null && jsonString.trim().length() > 0) {
            return JacksonParser.INSTANCE.toList(jsonString, User.class);
        }
        return new ArrayList<>();
    }

    public User getUserByID(int id) {
        List<User> userList = getUser();
        for (User user : userList) {
            if (user.getUserID() == id) {
                return user;
            }
        }
        return null;
    }
}
