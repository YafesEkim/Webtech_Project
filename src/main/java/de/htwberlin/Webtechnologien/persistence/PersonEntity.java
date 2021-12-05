package de.htwberlin.Webtechnologien.persistence;

import javax.persistence.*;

@Entity(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "is_member")
    private boolean member;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    public PersonEntity(String firstName, String lastName, boolean member, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.member = member;
        this.gender = gender;
    }

    protected PersonEntity(){}

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getMember() {
        return member;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
