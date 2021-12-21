package de.htwberlin.Webtechnologien.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "rechnungen")
public class RechnungEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firmenName", nullable = false)
    private String firmenName;

    @Column(name = "rechnungsart")
    @Enumerated(value = EnumType.STRING)
    private Rechnungsart rechnungsart;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private PersonEntity owner;

    public RechnungEntity() {
    }

    public RechnungEntity(String firmenName, Rechnungsart rechnungsart, PersonEntity owner) {
        this.firmenName = firmenName;
        this.rechnungsart = rechnungsart;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getFirmenName() {
        return firmenName;
    }

    public void setFirmenName(String name) {
        this.firmenName = name;
    }

    public Rechnungsart getRechnungsart() {
        return rechnungsart;
    }

    public void setRechnungsart(Rechnungsart rechnungsart) {
        this.rechnungsart = rechnungsart;
    }

    public PersonEntity getOwner() {
        return owner;
    }

    public void setOwner(PersonEntity owner) {
        this.owner = owner;
    }
}
