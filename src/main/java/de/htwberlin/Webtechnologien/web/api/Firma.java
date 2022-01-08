package de.htwberlin.Webtechnologien.web.api;

import java.util.List;

public class Firma {

    private long id;
    private String firmaName;
    private String address;
    private String ust_id;
    private boolean member;

    private List<Long> rechnungIds;

    public Firma(long id, String firmaName, String address, String ust_id, boolean member, List<Long> rechnungIds) {
        this.id = id;
        this.firmaName = firmaName;
        this.address = address;
        this.ust_id = ust_id;
        this.member = member;
        this.rechnungIds = rechnungIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<Long> getRechnungIds() {
        return rechnungIds;
    }

    public void setRechnungIds(List<Long> rechnungIds) {
        this.rechnungIds = rechnungIds;
    }
}
