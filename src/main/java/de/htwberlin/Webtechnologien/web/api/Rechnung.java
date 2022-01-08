package de.htwberlin.Webtechnologien.web.api;

public class Rechnung {

    private Long id;
    private String rechnungsNummer;
    private String rechnungsart;
    private String rechnungsDatum;
    private Firma firma;

    public Rechnung(Long id, String rechnungsNummer, String rechnungsart, String rechnungsDatum, Firma firma) {
        this.id = id;
        this.rechnungsNummer = rechnungsNummer;
        this.rechnungsart = rechnungsart;
        this.rechnungsDatum = rechnungsDatum;
        this.firma = firma;
    }

    public String getRechnungsDatum() {
        return rechnungsDatum;
    }

    public void setRechnungsDatum(String rechnungsDatum) {
        this.rechnungsDatum = rechnungsDatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRechnungsNummer() {
        return rechnungsNummer;
    }

    public void setRechnungsNummer(String rechnungsNummer) {
        this.rechnungsNummer = rechnungsNummer;
    }

    public String getRechnungsart() {
        return rechnungsart;
    }

    public void setRechnungsart(String rechnungsart) {
        this.rechnungsart = rechnungsart;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}
