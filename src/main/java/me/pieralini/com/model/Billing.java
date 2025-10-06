package me.pieralini.com.model;

import java.util.ArrayList;
import java.util.List;

public class Billing {
    private String nFat;
    private Double vOrig;
    private Double vDesc;
    private Double vLiq;
    private List<Duplicate> duplicates = new ArrayList<>();

    public String getnFat() { return nFat; }
    public void setnFat(String nFat) { this.nFat = nFat; }
    public Double getvOrig() { return vOrig; }
    public void setvOrig(Double vOrig) { this.vOrig = vOrig; }
    public Double getvDesc() { return vDesc; }
    public void setvDesc(Double vDesc) { this.vDesc = vDesc; }
    public Double getvLiq() { return vLiq; }
    public void setvLiq(Double vLiq) { this.vLiq = vLiq; }
    public List<Duplicate> getDuplicates() { return duplicates; }
    public void addDuplicate(Duplicate d) { duplicates.add(d); }

    @Override
    public String toString() {
        return "nFat=" + nFat + " vOrig=" + vOrig + " vLiq=" + vLiq + " duplicates=" + duplicates;
    }
}
