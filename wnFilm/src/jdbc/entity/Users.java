package jdbc.entity;

public class Users {
    private int id;
    private String userNo;
    private String passWord;
    private String phoneNum;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userNo='" + userNo + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Users() {
    }

    public Users(int id, String userNo, String passWord, String phoneNum) {
        this.id = id;
        this.userNo = userNo;
        this.passWord = passWord;
        this.phoneNum = phoneNum;
    }
}
