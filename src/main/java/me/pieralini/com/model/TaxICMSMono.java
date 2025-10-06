package me.pieralini.com.model;

public class TaxICMSMono {
    private String orig;
    private String cst;
    private Double qBCMonoRet;
    private Double adRemICMSRet;
    private Double vICMSMonoRet;

    public String getOrig() { return orig; }
    public void setOrig(String orig) { this.orig = orig; }
    public String getCst() { return cst; }
    public void setCst(String cst) { this.cst = cst; }
    public Double getqBCMonoRet() { return qBCMonoRet; }
    public void setqBCMonoRet(Double qBCMonoRet) { this.qBCMonoRet = qBCMonoRet; }
    public Double getAdRemICMSRet() { return adRemICMSRet; }
    public void setAdRemICMSRet(Double adRemICMSRet) { this.adRemICMSRet = adRemICMSRet; }
    public Double getvICMSMonoRet() { return vICMSMonoRet; }
    public void setvICMSMonoRet(Double vICMSMonoRet) { this.vICMSMonoRet = vICMSMonoRet; }

    @Override
    public String toString() {
        return "ICMSMono{orig=" + orig + " CST=" + cst + " qBCMonoRet=" + qBCMonoRet + " adRem=" + adRemICMSRet + " vICMSMonoRet=" + vICMSMonoRet + "}";
    }
}
