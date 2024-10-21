package com._assignment4.assignment4.animals;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;


    private String scientificName;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String habitat;

    private String description;

    public animal(int animalid, String name, String scientificName, String species, String habitat, String description){
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.species = species;
        this.habitat = habitat;
        this.description = description;
    }

    public animal(String name, String species, String habitat, String scientificName, String description){
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.species = species;
        this.scientificName = scientificName;
    }
    public animal(){

    }

    public int getAnimalID(){ return id;}

    public void setAnimalid(int id) {this.id = id;}

    public String getName(){ return name;}

    public void setName(String name){ this.name = name;}

    public String getScientificName(){ return scientificName;}

    public void setScientificName(String scientificName) { this.scientificName = scientificName;}

    public String getSpecies(){return species;}

    public void setSpecies(String species){this.species = species;}

    public String getHabitat(){return habitat;}

    public void setHabitat(String habitat){this.habitat = habitat;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}
}
