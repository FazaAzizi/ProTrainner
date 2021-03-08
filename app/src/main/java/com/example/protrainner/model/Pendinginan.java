package com.example.protrainner.model;

public class Pendinginan {
    String noPendinginan;
    String jenisPendinginan;
    String repsPendinginan;
    String durasiPendinginan;

    public Pendinginan() {
    }

    public Pendinginan(String noPendinginan, String jenisPendinginan, String repsPendinginan, String durasiPendinginan) {
        this.noPendinginan = noPendinginan;
        this.jenisPendinginan = jenisPendinginan;
        this.repsPendinginan = repsPendinginan;
        this.durasiPendinginan = durasiPendinginan;
    }


    public String getNoPendinginan() {
        return noPendinginan;
    }

    public void setNoPendinginan(String noPendinginan) {
        this.noPendinginan = noPendinginan;
    }

    public String getJenisPendinginan() {
        return jenisPendinginan;
    }

    public void setJenisPendinginan(String jenisPendinginan) {
        this.jenisPendinginan = jenisPendinginan;
    }

    public String getRepsPendinginan() {
        return repsPendinginan;
    }

    public void setRepsPendinginan(String repsPendinginan) {
        this.repsPendinginan = repsPendinginan;
    }

    public String getDurasiPendinginan() {
        return durasiPendinginan;
    }

    public void setDurasiPendinginan(String durasiPendinginan) {
        this.durasiPendinginan = durasiPendinginan;
    }
}
