package com.example.protrainner.model;

import java.security.PublicKey;

public class Harga {
    String noPaket;
    String durasiLatihan;
    String harga;

    public Harga(){
    }

    public Harga(String noPaket, String durasiLatihan, String harga){
        this.noPaket = noPaket;
        this.durasiLatihan = durasiLatihan;
        this.harga = harga;
    }

    public String getNoPaket() { return noPaket; }

    public void setNoPaket(String noPaket) { this.noPaket = noPaket; }

    public String getDurasiLatihan() { return durasiLatihan; }

    public void setDurasiLat(String durasiLatihan) { this.durasiLatihan = durasiLatihan; }

    public String getHarga() { return harga; }

    public void setHarga(String harga) { this.harga = harga; }

}
