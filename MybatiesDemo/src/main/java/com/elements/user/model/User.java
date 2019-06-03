package com.elements.user.model;

public class User {
    private int UserId;
    private String UserName;
    private String UserAge;

    public int getUserId ( ) {
        return UserId;
    }

    public void setUserId ( int userId ) {
        this.UserId = userId;
    }

    public String getUserName ( ) {
        return UserName;
    }

    public void setUserName ( String userName ) {
        UserName = userName;
    }

    public String getUserage ( ) {
        return UserAge;
    }

    public void setUserAge ( String userage ) {
        UserAge = userage;
    }

    @Override
    public String toString ( ) {
        return "User{" + "userId=" + UserId + ", UserName='" + UserName + '\'' + ", Userage='" + UserAge + '\'' + '}';
    }
}