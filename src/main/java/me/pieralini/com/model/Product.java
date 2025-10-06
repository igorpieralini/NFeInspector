package me.pieralini.com.model;

public class Product {
    private String itemNumber;
    private String code;
    private String ean;
    private String description;
    private String ncm;
    private String cfop;
    private String unit;
    private double quantity;
    private double unitValue;
    private double totalValue;
    private String eanTrib;
    private String unitTrib;
    private double quantityTrib;
    private double unitValueTrib;
    private String indTot;
    private String order;
    private CombInfo comb;
    private String infAdProd;

    public static class CombInfo {
        private String cProdANP;
        private String descANP;
        private Double pGLP;
        private Double pGNn;
        private Double pGNi;
        private String ufCons;

        public String getcProdANP() { return cProdANP; }
        public void setcProdANP(String cProdANP) { this.cProdANP = cProdANP; }
        public String getDescANP() { return descANP; }
        public void setDescANP(String descANP) { this.descANP = descANP; }
        public Double getpGLP() { return pGLP; }
        public void setpGLP(Double pGLP) { this.pGLP = pGLP; }
        public Double getpGNn() { return pGNn; }
        public void setpGNn(Double pGNn) { this.pGNn = pGNn; }
        public Double getpGNi() { return pGNi; }
        public void setpGNi(Double pGNi) { this.pGNi = pGNi; }
        public String getUfCons() { return ufCons; }
        public void setUfCons(String ufCons) { this.ufCons = ufCons; }

        @Override
        public String toString() {
            return "ANP{" + cProdANP + " " + descANP + " pGLP=" + pGLP + " pGNn=" + pGNn + " pGNi=" + pGNi + " ufCons=" + ufCons + "}";
        }
    }

    public String getItemNumber() { return itemNumber; }
    public void setItemNumber(String itemNumber) { this.itemNumber = itemNumber; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getEan() { return ean; }
    public void setEan(String ean) { this.ean = ean; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getNcm() { return ncm; }
    public void setNcm(String ncm) { this.ncm = ncm; }
    public String getCfop() { return cfop; }
    public void setCfop(String cfop) { this.cfop = cfop; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
    public double getUnitValue() { return unitValue; }
    public void setUnitValue(double unitValue) { this.unitValue = unitValue; }
    public double getTotalValue() { return totalValue; }
    public void setTotalValue(double totalValue) { this.totalValue = totalValue; }
    public String getEanTrib() { return eanTrib; }
    public void setEanTrib(String eanTrib) { this.eanTrib = eanTrib; }
    public String getUnitTrib() { return unitTrib; }
    public void setUnitTrib(String unitTrib) { this.unitTrib = unitTrib; }
    public double getQuantityTrib() { return quantityTrib; }
    public void setQuantityTrib(double quantityTrib) { this.quantityTrib = quantityTrib; }
    public double getUnitValueTrib() { return unitValueTrib; }
    public void setUnitValueTrib(double unitValueTrib) { this.unitValueTrib = unitValueTrib; }
    public String getIndTot() { return indTot; }
    public void setIndTot(String indTot) { this.indTot = indTot; }
    public String getOrder() { return order; }
    public void setOrder(String order) { this.order = order; }
    public CombInfo getComb() { return comb; }
    public void setComb(CombInfo comb) { this.comb = comb; }
    public String getInfAdProd() { return infAdProd; }
    public void setInfAdProd(String infAdProd) { this.infAdProd = infAdProd; }

    @Override
    public String toString() {
        return "Item " + itemNumber + " Code:" + code + " Desc:" + description + " Qtty:" + quantity + " Unit:" + unit + " UnitValue:" + unitValue + " Total:" + totalValue + (comb != null ? " " + comb : "") + (infAdProd != null ? " Info:" + infAdProd : "");
    }
}
