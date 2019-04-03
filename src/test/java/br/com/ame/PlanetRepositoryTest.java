package br.com.ame;

import br.com.ame.model.Planet;
import br.com.ame.repository.PlanetRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository repository;

    @Test
    public void whenFindByName_thenReturnPlanet(){
        Planet planet = Planet.builder()
                .name("Teste")
                .climate("Clima")
                .terrain("Terreno")
                .films(Lists.newArrayList())
                .build();
        repository.save(planet);
        repository.flush();

        Planet result = repository.findByName("Teste");
        assertEquals(planet, result);
    }
}
