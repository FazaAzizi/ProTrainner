package com.example.protrainner.model;

public class Pengukuran {
    String tanggal;
    String tb;
    String bb;
    String bf;
    String bmi;
    String vf;
    String ba;
    String ll;
    String ld;
    String lgang;
    String lgul;
    String lp;
    String lb;

    public Pengukuran() {
    }

    public Pengukuran(String tanggal, String tb, String bb, String bf, String bmi, String vf,
                      String ba, String ll, String ld, String lgang, String lgul, String lp, String lb) {
        this.tanggal = tanggal;
        this.tb = tb;
        this.bb = bb;
        this.bf = bf;
        this.bmi = bmi;
        this.vf = vf;
        this.ba = ba;
        this.ll = ll;
        this.ld = ld;
        this.lgang = lgang;
        this.lgul = lgul;
        this.lp = lp;
        this.lb = lb;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTb() {
        return tb;
    }

    public void setTb(String tb) {
        this.tb = tb;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getBf() {
        return bf;
    }

    public void setBf(String bf) {
        this.bf = bf;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getVf() {
        return vf;
    }

    public void setVf(String vf) {
        this.vf = vf;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getLl() {
        return ll;
    }

    public void setLl(String ll) {
        this.ll = ll;
    }

    public String getLd() {
        return ld;
    }

    public void setLd(String ld) {
        this.ld = ld;
    }

    public String getLgang() {
        return lgang;
    }

    public void setLgang(String lgang) {
        this.lgang = lgang;
    }

    public String getLgul() {
        return lgul;
    }

    public void setLgul(String lgul) {
        this.lgul = lgul;
    }

    public String getLp() {
        return lp;
    }

    public void setLp(String lp) {
        this.lp = lp;
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }
}
