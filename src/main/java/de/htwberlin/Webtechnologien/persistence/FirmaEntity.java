package de.htwberlin.Webtechnologien.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "firma")
public class FirmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firma_name", nullable = false)
    private String firmaName;

    @Column(name = "firma_address", nullable = false)
    private String firmaAddress;


    @Column(name = "ust_id", nullable = false)
    private String ust_id;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<RechnungEntity> rechnungen = new ArrayList<>();

    public FirmaEntity(String firmaName, String firmaAddress, String ust_id) {
        this.firmaName = firmaName;
        this.firmaAddress = firmaAddress;
        this.ust_id = ust_id;
    }

    protected FirmaEntity(){}

    public long getId() {
        return id;
    }

    public String getFirmaName() {
        return firmaName;
    }

    public String getFirmaAddress() {
        return firmaAddress;
    }


    public void setFirmaName(String firstName) {
        this.firmaName = firstName;
    }

    public void setFirmaAddress(String lastName) {
        this.firmaAddress = lastName;
    }


    public String getUst_id() {
        return ust_id;
    }

    public void setUst_id(String ust_id) {
        this.ust_id = ust_id;
    }

    public List<RechnungEntity> getRechnungen() {
        return rechnungen;
    }

    public void setRechnungen(List<RechnungEntity> rechnungen) {
        this.rechnungen = rechnungen;
    }
}
