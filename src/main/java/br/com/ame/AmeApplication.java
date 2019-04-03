package br.com.ame;

import br.com.ame.model.Planet;
import br.com.ame.repository.PlanetRepository;
import br.com.ame.service.SwapiService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmeApplication.class, args);
	}
}
