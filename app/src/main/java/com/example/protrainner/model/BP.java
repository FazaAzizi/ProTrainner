package com.example.protrainner.model;

public class BP {
    String no;
    String membername;
    String phonenumber;
    String goal;
    String ppackage;
    String sessionperweek;
    String balance;
    String expireddate;
    String newpackage;
    String renewal;
    String packagesaleprice;

    public BP() {
    }

    public BP(String no, String membername, String phonenumber, String goal, String ppackage, String sessionperweek, String balance, String expireddate, String newpackage, String renewal, String packagesaleprice) {
        this.no = no;
        this.membername = membername;
        this.phonenumber = phonenumber;
        this.goal = goal;
        this.ppackage = ppackage;
        this.sessionperweek = sessionperweek;
        this.balance = balance;
        this.expireddate = expireddate;
        this.newpackage = newpackage;
        this.renewal = renewal;
        this.packagesaleprice = packagesaleprice;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getPpackage() {
        return ppackage;
    }

    public void setPpackage(String ppackage) {
        this.ppackage = ppackage;
    }

    public String getSessionperweek() {
        return sessionperweek;
    }

    public void setSessionperweek(String sessionperweek) {
        this.sessionperweek = sessionperweek;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getExpireddate() {
        return expireddate;
    }

    public void setExpireddate(String expireddate) {
        this.expireddate = expireddate;
    }

    public String getNewpackage() {
        return newpackage;
    }

    public void setNewpackage(String newpackage) {
        this.newpackage = newpackage;
    }

    public String getRenewal() {
        return renewal;
    }

    public void setRenewal(String renewal) {
        this.renewal = renewal;
    }

    public String getPackagesaleprice() {
        return packagesaleprice;
    }

    public void setPackagesaleprice(String packagesaleprice) {
        this.packagesaleprice = packagesaleprice;
    }
}
