package de.htwberlin.Webtechnologien.service;

import de.htwberlin.Webtechnologien.persistence.FirmaEntity;
import de.htwberlin.Webtechnologien.persistence.FirmaRepository;
import de.htwberlin.Webtechnologien.web.api.Firma;
import de.htwberlin.Webtechnologien.web.api.FirmaManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FirmaService {

    private final FirmaRepository firmaRepository;
    private final FirmaTransformer firmaTransformer;

    public FirmaService(FirmaRepository firmaRepository, FirmaTransformer firmaTransformer){
        this.firmaRepository = firmaRepository;
        this.firmaTransformer = firmaTransformer;
    }

    public List<Firma> findAll(){
        List<FirmaEntity> firmen = firmaRepository.findAll();
        return firmen.stream()
                .map(firmaTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Firma findById(Long id){
        var firmaEntity = firmaRepository.findById(id);
        return firmaEntity.map(firmaTransformer::transformEntity).orElse(null);
    }

    public Firma create(FirmaManipulationRequest request){
        //var gender = Gender.valueOf(request.getUst_id());
        var firmaEntity = new FirmaEntity(request.getFirmaName(),request.getAddress(), request.getUst_id());
        firmaEntity = firmaRepository.save(firmaEntity);
        return firmaTransformer.transformEntity(firmaEntity);
    }

    public Firma update (Long id, FirmaManipulationRequest request){
        var firmaEntityOptional = firmaRepository.findById(id);
        if(firmaEntityOptional.isEmpty()){
            return null;
        }

        var firmaEntity = firmaEntityOptional.get();
        firmaEntity.setFirmaName(request.getFirmaName());
        firmaEntity.setFirmaAddress(request.getAddress());
        firmaEntity.setUst_id(request.getUst_id());

        firmaEntity = firmaRepository.save(firmaEntity);

        return firmaTransformer.transformEntity(firmaEntity);
    }

    public boolean deleteById(Long id){
        if(!firmaRepository.existsById(id)){
            return false;
        }

        firmaRepository.deleteById(id);
        return true;
    }


}
