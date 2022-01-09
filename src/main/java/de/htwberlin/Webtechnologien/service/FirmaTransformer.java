package de.htwberlin.Webtechnologien.service;

import de.htwberlin.Webtechnologien.persistence.FirmaEntity;
import de.htwberlin.Webtechnologien.persistence.RechnungEntity;
import de.htwberlin.Webtechnologien.web.api.Firma;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FirmaTransformer {

    public Firma transformEntity(FirmaEntity firmaEntity){
        var rechnungIds = firmaEntity.getRechnungen().stream().map(RechnungEntity::getId).collect(Collectors.toList());
        return new Firma(
                firmaEntity.getId(),
                firmaEntity.getFirmaName(),
                firmaEntity.getFirmaAddress(),
                firmaEntity.getUst_id(),
                rechnungIds);
    }
}
