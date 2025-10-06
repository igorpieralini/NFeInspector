package me.pieralini.com.model;

public class Volume {
    private Integer qVol;
    private String esp;
    private Integer nVol;
    private Double pesoL;
    private Double pesoB;

    public Integer getqVol() { return qVol; }
    public void setqVol(Integer qVol) { this.qVol = qVol; }
    public String getEsp() { return esp; }
    public void setEsp(String esp) { this.esp = esp; }
    public Integer getnVol() { return nVol; }
    public void setnVol(Integer nVol) { this.nVol = nVol; }
    public Double getPesoL() { return pesoL; }
    public void setPesoL(Double pesoL) { this.pesoL = pesoL; }
    public Double getPesoB() { return pesoB; }
    public void setPesoB(Double pesoB) { this.pesoB = pesoB; }

    @Override
    public String toString() { return "vols:" + qVol + " esp:" + esp + " pesoL:" + pesoL + " pesoB:" + pesoB; }
}
