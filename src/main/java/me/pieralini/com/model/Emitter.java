package me.pieralini.com.model;

public class Emitter {
    private String cnpj;
    private String name;
    private Address address;
    private String ie;
    private String crt;
    private String phone;

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public String getIe() { return ie; }
    public void setIe(String ie) { this.ie = ie; }
    public String getCrt() { return crt; }
    public void setCrt(String crt) { this.crt = crt; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return name + " (" + cnpj + ") IE:" + ie + " Address: " + (address != null ? address.toString() : "n/a") + " Phone:" + phone;
    }
}
