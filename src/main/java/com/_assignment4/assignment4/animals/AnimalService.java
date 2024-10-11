package com._assignment4.assignment4.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    public List<animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public animal getAnimalbyID(int animalid) {
        Optional<animal> animal = animalRepository.getAnimalbyID(animalid);
        return animal.orElse(null);
    }

    public List<animal> getAnimalsByScientificName(String scientficName) {
        return animalRepository.getAnimalsByScientificName(scientficName);
    }

    public List<animal> getAnimalsofSameSpecies(String species) {
        return animalRepository.getAnimalsofSameSpecies(species);
    }

    public void addNewAnimal(animal animal) {
        animalRepository.save(animal);
    }

    public void updateAnimal(int animalid, animal animal) {
        animalRepository.save(animal);
    }

    public void deleteAnimalById(int animalid) {
        animalRepository.deleteAnimalById(animalid);
    }
}


