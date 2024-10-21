package com._assignment4.assignment4.animals;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/animals")
public class animalController {

    @Autowired
    private AnimalService service;

    @GetMapping("/all")
    public List<animal> getAllAnimals(){return service.getAllAnimals();}

    @GetMapping("/{id}")
    public animal findAnimalById(@PathVariable int id) {return service.findAnimalByID(id);}

    @GetMapping("")
    public List<animal> getAnimalsByScientificName(@RequestParam(name = "scientificName", defaultValue = "null") String scientificName){
        return service.getAnimalsByScientificName(scientificName);
    }

    @GetMapping("/species")
    public List<animal> getAnimalsofSameSpecies (@RequestParam(name = "species", defaultValue = "null") String species){
    return service.getAnimalsofSameSpecies(species);
    }

   @PostMapping("/new")
    public List<animal> addNewAnimal(@RequestBody animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
   }

   @PutMapping("/update/{id}")
    public animal updateAnimal(@PathVariable int id, @RequestBody animal animal){
        service.updateAnimal(id, animal);
        return service.findAnimalByID(id);
   }
   @DeleteMapping("/delete/{id}")
    public List<animal> deleteAnimalbyId(@PathVariable int id){
        service.deleteAnimalById(id);
        return service.getAllAnimals();
   }


}
