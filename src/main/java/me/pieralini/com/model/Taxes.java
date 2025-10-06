package me.pieralini.com.model;

public class Taxes {
    private TaxICMSMono icmsMono;
    private String pisCst;
    private String cofinsCst;

    public TaxICMSMono getIcmsMono() { return icmsMono; }
    public void setIcmsMono(TaxICMSMono icmsMono) { this.icmsMono = icmsMono; }
    public String getPisCst() { return pisCst; }
    public void setPisCst(String pisCst) { this.pisCst = pisCst; }
    public String getCofinsCst() { return cofinsCst; }
    public void setCofinsCst(String cofinsCst) { this.cofinsCst = cofinsCst; }

    @Override
    public String toString() {
        return (icmsMono != null ? icmsMono.toString() : "") + " PIS_CST:" + pisCst + " COFINS_CST:" + cofinsCst;
    }
}
