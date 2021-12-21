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
    private List <Long> rechnungen;

    public Person(long id, String firstName, String lastName, String gender, boolean member, List<Long> rechnungen) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.member = member;
        this.rechnungen = rechnungen;
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

    public List<Long> getRechnungen() {
        return rechnungen;
    }

    public void setRechnungen(List<Long> rechnungen) {
        this.rechnungen = rechnungen;
    }
}
