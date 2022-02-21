package model.user;

public class User {
    private String userID;
    private String userName;
    private String password;
    private String decentralization;

    public User(String userID, String userName, String password, String decentralization) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.decentralization = decentralization;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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

    public String getDecentralization() {
        return decentralization;
    }

    public void setDecentralization(String decentralization) {
        this.decentralization = decentralization;
    }

}
