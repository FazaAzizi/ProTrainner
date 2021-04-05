package com.example.protrainner.model;

public class Akun {
    String email;
    String fullname;
    String isMember;
    String alamatjogja;
    String alamatasal;
    String jeniskelamin;
    String pengalaman;
    String namalengkap;
    String ttl;
    String usia;

    public Akun() {
    }

    public Akun(String email, String fullname, String isMember, String alamatjogja,
                String alamatasal, String jeniskelamin, String pengalaman,
                String namalengkap, String ttl, String usia) {
        this.email = email;
        this.fullname = fullname;
        this.isMember = isMember;
        this.alamatjogja = alamatjogja;
        this.alamatasal = alamatasal;
        this.jeniskelamin = jeniskelamin;
        this.pengalaman = pengalaman;
        this.namalengkap = namalengkap;
        this.ttl = ttl;
        this.usia = usia;
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

    public String getAlamatjogja() {
        return alamatjogja;
    }

    public void setAlamatjogja(String alamatjogja) {
        this.alamatjogja = alamatjogja;
    }

    public String getAlamatasal() {
        return alamatasal;
    }

    public void setAlamatasal(String alamatasal) {
        this.alamatasal = alamatasal;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }
}
