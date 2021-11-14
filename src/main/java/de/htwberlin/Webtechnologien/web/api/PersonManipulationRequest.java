package de.htwberlin.Webtechnologien.web.api;

public class PersonManipulationRequest {

    private String firstName;
    private String lastName;
    private boolean member;

    public PersonManipulationRequest(String firstName, String lastName, boolean member) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.member = member;
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
