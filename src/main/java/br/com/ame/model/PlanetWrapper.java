package br.com.ame.model;

import lombok.Data;

import java.util.List;

@Data
public class PlanetWrapper {

    private int count;
    private List<Planet> results;
    private String next;
}
