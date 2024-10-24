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
    public List<animal> getAnimalsofSameSpecies (@RequestParam(name = "species", defaultValue = "null")String species, Model model){
        return service.getAnimalsofSameSpecies(species);
    }
    @GetMapping("/createForm")
    public String showCreateForm(){
        return "animal-create";
    }

   @PostMapping("/new")
    public String addNewAnimal( animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/all";
   }
    @GetMapping("/update/{id}")
   public String showUpdateForm(@PathVariable int id, Model model){
        model.addAttribute("animal", service.findAnimalByID(id));
        return "animal-update";
   }

   @PostMapping("/update")
    public String updateAnimal(animal animal){
       service.addNewAnimal(animal);
        return "redirect:/animals/" + animal.getId();
   }
    @PostMapping("/delete/{id}")
    public String deleteAnimalById(@PathVariable int id) {
        service.deleteAnimalById(id);
        return "redirect:/animals/all";
    }


}
