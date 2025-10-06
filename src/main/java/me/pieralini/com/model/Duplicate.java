package me.pieralini.com.model;

public class Duplicate {
    private String nDup;
    private String dVenc;
    private Double vDup;

    public String getnDup() { return nDup; }
    public void setnDup(String nDup) { this.nDup = nDup; }
    public String getdVenc() { return dVenc; }
    public void setdVenc(String dVenc) { this.dVenc = dVenc; }
    public Double getvDup() { return vDup; }
    public void setvDup(Double vDup) { this.vDup = vDup; }

    @Override
    public String toString() { return nDup + " due:" + dVenc + " v:" + vDup; }
}
