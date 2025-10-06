package me.pieralini.com.model;

public class Recipient {
    private String cnpjOrCpf;
    private String name;
    private Address address;
    private String indIEDest;
    private String ie;
    private String email;
    private String phone;

    public String getCnpjOrCpf() { return cnpjOrCpf; }
    public void setCnpjOrCpf(String cnpjOrCpf) { this.cnpjOrCpf = cnpjOrCpf; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public String getIndIEDest() { return indIEDest; }
    public void setIndIEDest(String indIEDest) { this.indIEDest = indIEDest; }
    public String getIe() { return ie; }
    public void setIe(String ie) { this.ie = ie; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return name + " (" + cnpjOrCpf + ") IE:" + ie + " Email:" + email + " Address: " + (address != null ? address.toString() : "n/a") + " Phone:" + phone;
    }
}
