package com._assignment4.assignment4.animals;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
@Controller
@RequestMapping("/animals")
public class animalController {

    @Autowired
    private AnimalService service;

    @GetMapping("/all")
    public String getAllAnimals(Model model){
        model.addAttribute("animalList", service.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list";}

    @GetMapping("/{id}")
    public String findAnimalById(@PathVariable int id, Model model) {
        model.addAttribute("animal", service.findAnimalByID(id));
        model.addAttribute("title", id);
        return "animal-details";}

    @GetMapping("/species")
    public String getAnimalsofSameSpecies (@RequestParam(name = "species", defaultValue = "null")String species, Model model){
        model.addAttribute("Species", service.getAnimalsofSameSpecies(species));
        model.addAttribute("Title", "Animals of species: "+species);
        return "animal-list";
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
