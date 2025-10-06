package me.pieralini.com.model;

public class Address {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String cityCode;
    private String city;
    private String uf;
    private String zip;
    private String countryCode;
    private String country;

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getComplement() { return complement; }
    public void setComplement(String complement) { this.complement = complement; }
    public String getNeighborhood() { return neighborhood; }
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }
    public String getCityCode() { return cityCode; }
    public void setCityCode(String cityCode) { this.cityCode = cityCode; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @Override
    public String toString() {
        return street + ", " + number + (complement != null ? " " + complement : "") + ", " + neighborhood + ", " + city + " - " + uf + " CEP:" + zip;
    }
}
