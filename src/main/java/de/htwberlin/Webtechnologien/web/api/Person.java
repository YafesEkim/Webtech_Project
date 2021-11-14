package de.htwberlin.Webtechnologien.web.api;

public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private boolean member;

    public Person(long id, String firstName, String lastName, boolean member) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.member = member;
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


}
