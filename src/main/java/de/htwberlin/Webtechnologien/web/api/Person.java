package de.htwberlin.Webtechnologien.web.api;

import de.htwberlin.Webtechnologien.persistence.RechnungEntity;

import java.util.List;

public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private boolean member;
   // private Rechnung rechnung;
    private List<Long> rechnungIds;

    public Person(long id, String firstName, String lastName, String gender, boolean member, List<Long> rechnungIds) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.member = member;
        this.rechnungIds = rechnungIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Long> getRechnungIds() {
        return rechnungIds;
    }

    public void setRechnungIds(List<Long> rechnungIds) {
        this.rechnungIds = rechnungIds;
    }
}
