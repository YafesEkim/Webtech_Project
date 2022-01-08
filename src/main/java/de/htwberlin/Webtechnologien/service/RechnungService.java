package de.htwberlin.Webtechnologien.service;

import de.htwberlin.Webtechnologien.persistence.*;
import de.htwberlin.Webtechnologien.web.api.Rechnung;
import de.htwberlin.Webtechnologien.web.api.RechnungManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class  RechnungService {

    private final RechnungsRepository rechnungsRepository;
    private final FirmaRepository firmaRepository;
    private final FirmaTransformer firmaTransformer;

    public RechnungService(RechnungsRepository rechnungsRepository, FirmaRepository firmaRepository, FirmaTransformer firmaTransformer) {
        this.rechnungsRepository = rechnungsRepository;
        this.firmaRepository = firmaRepository;
        this.firmaTransformer = firmaTransformer;
    }

    public List<Rechnung> findAll() {
        List<RechnungEntity> rechnungen = rechnungsRepository.findAll();
        return rechnungen.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Rechnung create(RechnungManipulationRequest request) {
        var rechnungsart = Rechnungsart.valueOf(request.getRechnungsart());
        var owner = firmaRepository.findById(request.getOwnerId()).orElseThrow();
        var rechnungEntity = new RechnungEntity(request.getRechnungsNummer(), rechnungsart, request.getRechnungsDatum(), owner);
        rechnungEntity = rechnungsRepository.save(rechnungEntity);
        return transformEntity(rechnungEntity);
    }

    private Rechnung transformEntity(RechnungEntity rechnungEntity) {
        var rechnungsart = rechnungEntity.getRechnungsart() != null ? rechnungEntity.getRechnungsart().name() : Rechnungsart.EINNAHME.name();
        return new Rechnung(
                rechnungEntity.getId(),
                rechnungEntity.getRechnungsNummer(),
                rechnungsart,
                rechnungEntity.getRechnungsDatum(),
                firmaTransformer.transformEntity(rechnungEntity.getOwner()));
    }
}
