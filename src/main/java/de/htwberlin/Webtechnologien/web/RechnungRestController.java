package de.htwberlin.Webtechnologien.web;

import de.htwberlin.Webtechnologien.service.RechnungService;
import de.htwberlin.Webtechnologien.web.api.Rechnung;
import de.htwberlin.Webtechnologien.web.api.RechnungManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RechnungRestController {

    private final RechnungService rechnungService;

    public RechnungRestController(RechnungService rechnungService) {
        this.rechnungService = rechnungService;
    }

    @GetMapping(path = "/api/v1/rechnungen")
    public ResponseEntity<List<Rechnung>> fetchRechnungen() {
        return ResponseEntity.ok(rechnungService.findAll());
    }

    @PostMapping(path = "/api/v1/rechnungen")
    public ResponseEntity<Void> createRechnung(@RequestBody RechnungManipulationRequest request) throws URISyntaxException {
        var rechnung = rechnungService.create(request);
        URI uri = new URI("/api/v1/rechnungen/" + rechnung.getId());
        return ResponseEntity.created(uri).build();
    }
}
