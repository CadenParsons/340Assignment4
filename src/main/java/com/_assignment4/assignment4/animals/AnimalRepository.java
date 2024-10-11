package com._assignment4.assignment4.animals;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<animal, Integer>{

    List<animal> getAnimalsByScientificName(String scientficName);

    @Query(value = "Select * from animals s who are part of the same species", nativeQuery = true)
    List<animal> getAnimalsofSameSpecies(String species);

    void deleteAnimalById(int animalid);

    Optional<animal> getAnimalbyID(int animalid);
}
