package model.user;


public class User {
    private int userID;
    private String userName;
    private String password;
    private Role role;

    public User(int userID, String userName, String password, Role role) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User(String raw) {
        String[] strings = raw.split(",");
        this.userID = Integer.parseInt(strings[0]);
        this.userName = strings[1];
        this.password = strings[2];
        this.role = Role.fromValue(strings[0]);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
