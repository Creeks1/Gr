package com.example.gymfit.Model;

public class Users {
    private String email, number, numberConfirmation;

    public Users()
    {

    }

    public Users(String email, String number, String password) {
        this.email = email;
        this.number = number;
        this.numberConfirmation = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return numberConfirmation;
    }

    public void setPassword(String password) {
        this.numberConfirmation = password;
    }
}
