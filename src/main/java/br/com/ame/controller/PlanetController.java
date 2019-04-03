package br.com.ame.controller;

import br.com.ame.model.Planet;
import br.com.ame.repository.PlanetRepository;
import br.com.ame.service.SwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private SwapiService swapi;

    @Autowired
    private PlanetRepository repository;

    @GetMapping
    public List<Planet> getAll(){
        return repository.findAll();
    }

    @GetMapping("/api")
    public Set<Planet> getAll_API(){
        return swapi.getAll();
    }

    @PostMapping
    public Planet save(@RequestBody Planet planet){
        return repository.save(planet);
    }

}
