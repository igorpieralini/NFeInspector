package me.pieralini.com.model;

public class Totals {
    private Double vBC;
    private Double vICMS;
    private Double vICMSDeson;
    private Double vFCP;
    private Double vBCST;
    private Double vST;
    private Double vProd;
    private Double vFrete;
    private Double vSeg;
    private Double vDesc;
    private Double vII;
    private Double vIPI;
    private Double vPIS;
    private Double vCOFINS;
    private Double vOutro;
    private Double vNF;
    private Double qBCMonoRet;
    private Double vICMSMonoRet;

    public Double getvBC() { return vBC; }
    public void setvBC(Double vBC) { this.vBC = vBC; }
    public Double getvICMS() { return vICMS; }
    public void setvICMS(Double vICMS) { this.vICMS = vICMS; }
    public Double getvICMSDeson() { return vICMSDeson; }
    public void setvICMSDeson(Double vICMSDeson) { this.vICMSDeson = vICMSDeson; }
    public Double getvFCP() { return vFCP; }
    public void setvFCP(Double vFCP) { this.vFCP = vFCP; }
    public Double getvBCST() { return vBCST; }
    public void setvBCST(Double vBCST) { this.vBCST = vBCST; }
    public Double getvST() { return vST; }
    public void setvST(Double vST) { this.vST = vST; }
    public Double getvProd() { return vProd; }
    public void setvProd(Double vProd) { this.vProd = vProd; }
    public Double getvFrete() { return vFrete; }
    public void setvFrete(Double vFrete) { this.vFrete = vFrete; }
    public Double getvSeg() { return vSeg; }
    public void setvSeg(Double vSeg) { this.vSeg = vSeg; }
    public Double getvDesc() { return vDesc; }
    public void setvDesc(Double vDesc) { this.vDesc = vDesc; }
    public Double getvII() { return vII; }
    public void setvII(Double vII) { this.vII = vII; }
    public Double getvIPI() { return vIPI; }
    public void setvIPI(Double vIPI) { this.vIPI = vIPI; }
    public Double getvPIS() { return vPIS; }
    public void setvPIS(Double vPIS) { this.vPIS = vPIS; }
    public Double getvCOFINS() { return vCOFINS; }
    public void setvCOFINS(Double vCOFINS) { this.vCOFINS = vCOFINS; }
    public Double getvOutro() { return vOutro; }
    public void setvOutro(Double vOutro) { this.vOutro = vOutro; }
    public Double getvNF() { return vNF; }
    public void setvNF(Double vNF) { this.vNF = vNF; }
    public Double getqBCMonoRet() { return qBCMonoRet; }
    public void setqBCMonoRet(Double qBCMonoRet) { this.qBCMonoRet = qBCMonoRet; }
    public Double getvICMSMonoRet() { return vICMSMonoRet; }
    public void setvICMSMonoRet(Double vICMSMonoRet) { this.vICMSMonoRet = vICMSMonoRet; }

    @Override
    public String toString() {
        return "vProd=" + vProd + " vNF=" + vNF + " vFrete=" + vFrete + " qBCMonoRet=" + qBCMonoRet + " vICMSMonoRet=" + vICMSMonoRet;
    }
}
