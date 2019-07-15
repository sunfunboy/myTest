package com.ssm.pojo;

public class User00 {
  private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String userAccount;
  private String password;
  private String mobileNumber;
  private String email;
  private String sex;

    @Override
    public String toString() {
        return "User00{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public User00() {
    }
}
