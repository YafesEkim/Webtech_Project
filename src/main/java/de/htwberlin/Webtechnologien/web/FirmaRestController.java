package de.htwberlin.Webtechnologien.web;

import de.htwberlin.Webtechnologien.service.FirmaService;
import de.htwberlin.Webtechnologien.web.api.Firma;
import de.htwberlin.Webtechnologien.web.api.FirmaManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class FirmaRestController {

    private final FirmaService firmaService;

    public FirmaRestController(FirmaService firmaService) {
        this.firmaService = firmaService;
    }

    @GetMapping(path = "/api/v1/firma")
    public ResponseEntity<List<Firma>> fetchFirma() {
        return ResponseEntity.ok(firmaService.findAll());
    }

    @GetMapping(path = "/api/v1/firma/{id}")
    public ResponseEntity<Firma> fetchFirmaById(@PathVariable Long id){
        var firma = firmaService.findById(id);
        return firma != null? ResponseEntity.ok(firma) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/firma")
    public ResponseEntity<Void> createFirma(@RequestBody FirmaManipulationRequest request) throws URISyntaxException {
        var firma = firmaService.create(request);
        URI uri = new URI("/api/v1/firma/" + firma.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/firma/{id}")
    public ResponseEntity<Firma> updateFirma(@PathVariable Long id, @RequestBody FirmaManipulationRequest request){
        var firma = firmaService.update(id, request);
        return firma != null? ResponseEntity.ok(firma) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/firma/{id}")
    public ResponseEntity<Void> deleteFirma(@PathVariable Long id){
        boolean successful = firmaService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
