package org.polytech.covidapi.Rest.Public;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.polytech.covidapi.Repository.RendezVousRepository;
import org.polytech.covidapi.Services.RendezVousService;
import org.polytech.covidapi.Table.RendezVous;
import org.polytech.covidapi.Table.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.Refill;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;

@RestController
@RequestMapping("/api")
public class RendezVousRest {
    @Autowired
    private RendezVousService rendezVousService;
    private final RendezVousRepository repository;
    private final MeterRegistry registry;

    Refill refill = Refill.intervally(10, Duration.ofMinutes(1));

    Bandwidth limit = Bandwidth.classic(10, refill);
    Bucket bucket = Bucket.builder().addLimit(limit).build();

    final String remainning = "X-Rate-Limit-Remaining";
    final String retryAfter = "X-Rate-Limit-Retry-After-Seconds";

    RendezVousRest(RendezVousRepository repository, MeterRegistry registry){
        this.repository = repository;
        this.registry = registry;
    }
    

    @CrossOrigin
    @GetMapping(path ="/rdvs")
    public List<RendezVous> getAll(){
        return rendezVousService.getRendezVous();
    }

    @CrossOrigin
    @GetMapping(path = "/rdvs/{mail}")
    public List<RendezVous> getByEmail(
        @PathVariable("mail") String mail){
        return rendezVousService.getByEmail(mail);
    }

    /*@GetMapping(path="/rdv")
    public List<RendezVous> getByName(String name){
        return rendezVousService.getByName(name);
    }*/
    @CrossOrigin
    @GetMapping(path = "/centerRdv")
    public List<RendezVous> getByCentre(Centre centerId){
        return rendezVousService.getByCentre(centerId);
    }
    @CrossOrigin(exposedHeaders = {remainning, retryAfter})
    @PostMapping(path = "/appointment")
    public ResponseEntity newRendezVous(@RequestBody RendezVous newRendezVous){
        HttpHeaders headers = new HttpHeaders();
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        if(probe.isConsumed()){
            headers.add("X-Rate-Limit-Remaining", Long.toString(probe.getRemainingTokens()));
            Metrics.counter("Nombre de rendez-vous : ").increment();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(repository.save(newRendezVous));
        }
        
        Long delaiEnSeconde = probe.getNanosToWaitForRefill() / 1_000_000_000;
        headers.add("X-Rate-Limit-Retry-After-Seconds", String.valueOf(delaiEnSeconde));
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .headers(headers)
                .build();

    }
    
}
