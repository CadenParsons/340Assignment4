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

    public animal findAnimalByID(int id) {
        Optional<animal> animal = animalRepository.findAnimalByID(id);
        return animal.orElse(null);
    }

    public List<animal> getAnimalsByScientificName(String scientificName) {
        return animalRepository.getAnimalsByScientificName(scientificName);
    }

    public List<animal> getAnimalsofSameSpecies(String species) {
        return animalRepository.getAnimalsofSameSpecies(species);
    }

    public void addNewAnimal(animal animal) {
        animalRepository.save(animal);
    }

    public void updateAnimal(int id, animal animal) {
       animal existing = findAnimalByID(id);
       if (existing != null){
           existing.setName(animal.getName());
           existing.setScientificName(animal.getScientificName());
           existing.setSpecies(animal.getSpecies());
           existing.setHabitat(animal.getHabitat());
           existing.setDescription(animal.getDescription());
           animalRepository.save(animal);
       }


    }

    public void deleteAnimalById(int id) {
        animalRepository.deleteAnimalById(id);
    }
}


