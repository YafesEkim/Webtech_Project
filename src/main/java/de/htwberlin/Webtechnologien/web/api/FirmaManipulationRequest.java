package de.htwberlin.Webtechnologien.web.api;

public class FirmaManipulationRequest {

    private String firmaName;
    private String address;
    private String ust_id;
    private boolean member;

    public FirmaManipulationRequest(String firmaName, String address, String ust_id, boolean member) {
        this.firmaName = firmaName;
        this.address = address;
        this.ust_id = ust_id;
        this.member = member;
    }

    public FirmaManipulationRequest() {} // Parameterloser Konstruktor für die Postreuqests

    public String getFirmaName() {
        return firmaName;
    }

    public void setFirmaName(String firmaName) {
        this.firmaName = firmaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getUst_id() {
        return ust_id;
    }

    public void setUst_id(String ust_id) {
        this.ust_id = ust_id;
    }
}
