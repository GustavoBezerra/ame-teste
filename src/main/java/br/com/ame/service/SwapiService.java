package br.com.ame.service;

import br.com.ame.model.Planet;
import br.com.ame.model.PlanetWrapper;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Service
public class SwapiService {

    public final String URI_PLANETS = "https://swapi.co/api/planets/";

    @Autowired
    private RestTemplate restTemplate;

    public Set<Planet> getAll(){
        Set<Planet> planets = Sets.newLinkedHashSet();
        PlanetWrapper results;
        String nextURI = URI_PLANETS;
        do{
            results = restTemplate.getForObject(nextURI, PlanetWrapper.class);
            planets.addAll(results.getResults());
            nextURI = results.getNext();
        } while(!Strings.isNullOrEmpty(nextURI));

        return planets;
    }

    public Planet getOne(int id){
        return restTemplate.getForObject("https://swapi.co/api/planets/"+id, Planet.class);
    }

    public Planet getOne(String name){
        return restTemplate.getForObject("https://swapi.co/api/planets/?search="+name, Planet.class);
    }

}
