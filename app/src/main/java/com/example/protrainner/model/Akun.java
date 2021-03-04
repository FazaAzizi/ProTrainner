package com.example.protrainner.model;

public class Akun {
    private String email;
    private String fullname;
    private String isMember;

    public Akun() {
    }

    public Akun(String email, String fullname, String isMember) {
        this.email = email;
        this.fullname = fullname;
        this.isMember = isMember;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String Fullname) {
        this.fullname = Fullname;
    }


    public String getIsMember() {
        return isMember;
    }

    public void setIsMember(String isMember) {
        this.isMember = isMember;
    }
}
