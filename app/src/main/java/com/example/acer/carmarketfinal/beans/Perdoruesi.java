package com.example.acer.carmarketfinal.beans;

public class Perdoruesi {
    int id;
    String username,email, password;
    String krijuar_me;

    public Perdoruesi(int id, String username, String email, String password, String confirm) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;

    }
    public Perdoruesi(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKrijuar_me(String krijuar_me) {
        this.krijuar_me = krijuar_me;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


