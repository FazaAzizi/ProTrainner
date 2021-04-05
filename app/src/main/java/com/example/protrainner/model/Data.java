package com.example.protrainner.model;

public class Data {
    String alamatjogja;
    String jeniskelamin;
    String pengalaman;
    String namalengkap;
    String ttl;
    String usia;

    public Data() {
    }

    public Data(String alamatjogja, String jeniskelamin, String pengalaman, String namalengkap, String ttl, String usia) {
        this.alamatjogja = alamatjogja;
        this.jeniskelamin = jeniskelamin;
        this.pengalaman = pengalaman;
        this.namalengkap = namalengkap;
        this.ttl = ttl;
        this.usia = usia;
    }

    public String getAlamatjogja() {
        return alamatjogja;
    }

    public void setAlamatjogja(String alamatjogja) {
        this.alamatjogja = alamatjogja;
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
