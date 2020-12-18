package jdbc.entity;

public class User {
    private int ID;
    private String userName;
    private String userPass;
    private String userPhone;

    @Override
    public String toString() {
        return "user{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public User(int id, String userName, String userPass, String userPhone) {
        ID = id;
        this.userName = userName;
        this.userPass = userPass;
        this.userPhone = userPhone;
    }
}
