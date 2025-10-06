package me.pieralini.com.model;

public class Payment {
    private String indPag;
    private String tPag;
    private Double vPag;

    public String getIndPag() { return indPag; }
    public void setIndPag(String indPag) { this.indPag = indPag; }
    public String gettPag() { return tPag; }
    public void settPag(String tPag) { this.tPag = tPag; }
    public Double getvPag() { return vPag; }
    public void setvPag(Double vPag) { this.vPag = vPag; }

    @Override
    public String toString() {
        return "indPag=" + indPag + " tPag=" + tPag + " vPag=" + vPag;
    }
}
