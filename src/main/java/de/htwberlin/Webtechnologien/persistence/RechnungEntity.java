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

    @Column(name = "rechnungsnummer", nullable = false)
    private String rechnungsNummer;

    @Column(name = "rechnungsart")
    @Enumerated(value = EnumType.STRING)
    private Rechnungsart rechnungsart;

    @Column(name = "rechnungsdatum", nullable = false)
    private String rechnungsDatum;

    @Column(name = "betrag", nullable = false)
    private double betrag;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private FirmaEntity owner;

    public RechnungEntity() {
    }

    public RechnungEntity(String rechnungsNummer, Rechnungsart rechnungsart, String rechnungsDatum, double betrag, FirmaEntity owner) {
        this.rechnungsNummer = rechnungsNummer;
        this.rechnungsart = rechnungsart;
        this.rechnungsDatum = rechnungsDatum;
        this.betrag = betrag;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getRechnungsNummer() {
        return rechnungsNummer;
    }

    public void setRechnungsNummer(String name) {
        this.rechnungsNummer = name;
    }

    public Rechnungsart getRechnungsart() {
        return rechnungsart;
    }

    public void setRechnungsart(Rechnungsart rechnungsart) {
        this.rechnungsart = rechnungsart;
    }

    public String getRechnungsDatum() {
        return rechnungsDatum;
    }

    public void setRechnungsDatum(String rechnungsDatum) {
        this.rechnungsDatum = rechnungsDatum;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public FirmaEntity getOwner() {
        return owner;
    }

    public void setOwner(FirmaEntity owner) {
        this.owner = owner;
    }
}
