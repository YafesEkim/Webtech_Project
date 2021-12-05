package de.htwberlin.Webtechnologien.web.api;

public class Rechnung {

    private Long id;
    private String firmenName;
    private String rechnungsart;
    private Person person;

    public Rechnung(Long id, String firmenName, String rechnungsart, Person person) {
        this.id = id;
        this.firmenName = firmenName;
        this.rechnungsart = rechnungsart;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirmenName() {
        return firmenName;
    }

    public void setFirmenName(String firmenName) {
        this.firmenName = firmenName;
    }

    public String getRechnungsart() {
        return rechnungsart;
    }

    public void setRechnungsart(String rechnungsart) {
        this.rechnungsart = rechnungsart;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
