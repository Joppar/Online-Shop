package sample;

import javafx.beans.property.SimpleStringProperty;

import java.sql.*;

abstract public class Account {

    abstract public void setId(Integer id);

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public Integer getId() {
        return id;
    }

    protected SimpleStringProperty userName, password;
    protected Integer id;
    private static String user = "";

    public Account(String userName, String password) {
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
    }

    public static String getUser() {
        return user;
    }

}


