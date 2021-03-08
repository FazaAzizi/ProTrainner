package com.example.protrainner.model;

public class Pemanasan {
    String noPemanasan;
    String jenisPemanasan;
    String repsPemanasan;
    String durasiPemanasan;

    public Pemanasan() {
    }

    public Pemanasan(String noPemanasan, String jenisPemanasan, String repsPemanasan, String durasiPemanasan) {
        this.noPemanasan = noPemanasan;
        this.jenisPemanasan = jenisPemanasan;
        this.repsPemanasan = repsPemanasan;
        this.durasiPemanasan = durasiPemanasan;
    }

    public String getNoPemanasan() {
        return noPemanasan;
    }

    public void setNoPemanasan(String noPemanasan) {
        this.noPemanasan = noPemanasan;
    }

    public String getJenisPemanasan() {
        return jenisPemanasan;
    }

    public void setJenisPemanasan(String jenisPemanasan) {
        this.jenisPemanasan = jenisPemanasan;
    }

    public String getRepsPemanasan() {
        return repsPemanasan;
    }

    public void setRepsPemanasan(String repsPemanasan) {
        this.repsPemanasan = repsPemanasan;
    }

    public String getDurasiPemanasan() {
        return durasiPemanasan;
    }

    public void setDurasiPemanasan(String durasiPemanasan) {
        this.durasiPemanasan = durasiPemanasan;
    }
}
