package de.htwberlin.Webtechnologien.web.api;

public class RechnungManipulationRequest {

    private String name;
    private String rechnungsart;
    private Long ownerId;

    public RechnungManipulationRequest(String name, String rechnungsart, Long ownerId) {
        this.name = name;
        this.rechnungsart = rechnungsart;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRechnungsart() {
        return rechnungsart;
    }

    public void setRechnungsart(String rechnungsart) {
        this.rechnungsart = rechnungsart;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
