package de.htwberlin.Webtechnologien.web.api;

public class RechnungManipulationRequest {

    private String rechnungsNummer;
    private String rechnungsart;
    private String rechnungsDatum;
    private Long ownerId;

    public RechnungManipulationRequest(String rechnungsNummer, String rechnungsart, String rechnungsDatum, Long ownerId) {
        this.rechnungsNummer = rechnungsNummer;
        this.rechnungsart = rechnungsart;
        this.rechnungsDatum = rechnungsDatum;
        this.ownerId = ownerId;
    }

    public RechnungManipulationRequest(){}

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

    public String getRechnungsDatum() {
        return rechnungsDatum;
    }

    public void setRechnungsDatum(String rechnungsDatum) {
        this.rechnungsDatum = rechnungsDatum;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
