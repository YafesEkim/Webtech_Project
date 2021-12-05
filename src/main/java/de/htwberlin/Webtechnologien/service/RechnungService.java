package de.htwberlin.Webtechnologien.service;

import de.htwberlin.Webtechnologien.persistence.*;
import de.htwberlin.Webtechnologien.web.api.Rechnung;
import de.htwberlin.Webtechnologien.web.api.RechnungManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RechnungService {

    private final RechnungsRepository rechnungsRepository;
    private final PersonRepository personRepository;
    private final PersonTransformer personTransformer;

    public RechnungService(RechnungsRepository rechnungsRepository, PersonRepository personRepository, PersonTransformer personTransformer) {
        this.rechnungsRepository = rechnungsRepository;
        this.personRepository = personRepository;
        this.personTransformer = personTransformer;
    }

    public List<Rechnung> findAll() {
        List<RechnungEntity> pets = rechnungsRepository.findAll();
        return pets.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Rechnung create(RechnungManipulationRequest request) {
        var rechnungsart = Rechnungsart.valueOf(request.getRechnungsart());
        var owner = personRepository.findById(request.getOwnerId()).orElseThrow();
        var petEntity = new RechnungEntity(request.getName(), rechnungsart, owner);
        petEntity = rechnungsRepository.save(petEntity);
        return transformEntity(petEntity);
    }

    private Rechnung transformEntity(RechnungEntity rechnungEntity) {
        var rechnungsart = rechnungEntity.getRechnungsart() != null ? rechnungEntity.getRechnungsart().name() : Rechnungsart.EINNAHME.name();
        return new Rechnung(
                rechnungEntity.getId(),
                rechnungEntity.getFirmenName(),
                rechnungsart,
                personTransformer.transformEntity(rechnungEntity.getOwner()));
    }
}