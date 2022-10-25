package ra.bussiness.entity;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int userId;
    private String userName;
    private int phoneNuber;
    private String email;
    private String address;
    Date librarycardStartDay;
    Date librarycardEndday;
    private boolean userStatus;
    private String userLogin;
    private String userpass;
    private String comfirmUserPass;

    public User() {
    }

    public User(int userId, String userName, int phoneNuber, String email, String address, Date librarycardStartDay, Date librarycardEndday, boolean userStatus, String userLogin, String userpass, String comfirmUserPass) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNuber = phoneNuber;
        this.email = email;
        this.address = address;
        this.librarycardStartDay = librarycardStartDay;
        this.librarycardEndday = librarycardEndday;
        this.userStatus = userStatus;
        this.userLogin = userLogin;
        this.userpass = userpass;
        this.comfirmUserPass = comfirmUserPass;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPhoneNuber() {
        return phoneNuber;
    }

    public void setPhoneNuber(int phoneNuber) {
        this.phoneNuber = phoneNuber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLibrarycardStartDay() {
        return librarycardStartDay;
    }

    public void setLibrarycardStartDay(Date librarycardStartDay) {
        this.librarycardStartDay = librarycardStartDay;
    }

    public Date getLibrarycardEndday() {
        return librarycardEndday;
    }

    public void setLibrarycardEndday(Date librarycardEndday) {
        this.librarycardEndday = librarycardEndday;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getComfirmUserPass() {
        return comfirmUserPass;
    }

    public void setComfirmUserPass(String comfirmUserPass) {
        this.comfirmUserPass = comfirmUserPass;
    }
}
