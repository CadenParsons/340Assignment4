package com._assignment4.assignment4.animals;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class animal {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int animalid;

    @Column(nullable = false)
    private String name;


    private String scientficName;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String habitat;

    private String description;

    public animal(int animalid, String name, String scientficName, String species, String habitat, String description){
        this.animalid = animalid;
        this.name = name;
        this.scientficName = scientficName;
        this.species = species;
        this.habitat = habitat;
        this.description = description;
    }

    public animal(String name, String species, String habitat, String scientficName, String description){
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.species = species;
        this.scientficName = scientficName;
    }
    public animal(){

    }

    public int getAnimalid(){ return animalid;}

    public void setAnimalid(int animalid) {this.animalid = animalid;}

    public String getName(){ return name;}

    public void setName(String name){ this.name = name;}

    public String getScientificName(){ return scientficName;}

    public void setScientificName(String scientficName) { this.scientficName = scientficName;}

    public String getSpecies(){return species;}

    public void setSpecies(String species){this.species = species;}

    public String getHabitat(){return habitat;}

    public void setHabitat(String habitat){this.habitat = habitat;}

    public String getDescription(){return description;}

    public void setDescription(String description) {
        this.description = description;
    }
}
