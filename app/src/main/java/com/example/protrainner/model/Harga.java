package com.example.protrainner.model;

import java.security.PublicKey;

public class Harga {
    String noPaket;
    String durasiLat;
    String harga;

    public Harga(){
    }

    public Harga(String noPaket, String durasiLat, String harga){
        this.noPaket = noPaket;
        this.durasiLat = durasiLat;
        this.harga = harga;
    }

    public String getNoPaket() { return noPaket; }

    public void setNoPaket(String noPaket) { this.noPaket = noPaket; }

    public String getDurasiLat() { return durasiLat; }

    public void setDurasiLat(String durasiLat) { this.durasiLat = durasiLat; }

    public String getHarga() { return harga; }

    public void setHarga(String harga) { this.harga = harga; }

}
