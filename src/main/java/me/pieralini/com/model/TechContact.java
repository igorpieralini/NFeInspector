package me.pieralini.com.model;

public class TechContact {
    private String cnpj;
    private String contact;
    private String email;
    private String phone;

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() { return contact + " (" + cnpj + ") " + email + " " + phone; }
}
