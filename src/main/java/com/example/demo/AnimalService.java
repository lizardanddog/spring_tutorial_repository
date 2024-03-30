package com.example.demo;

import com.example.demo.Entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository=animalRepository;
    }

    public void buyAnimal(String name, String species, double price){
        Animal newAnimal= new Animal(name,species,price);
        animalRepository.save(newAnimal);
    }

    public List<Animal> getAnimals(){
        return animalRepository.findAll();
    }

    public String removeAnimal(Long animalID){
        Optional<Animal> animalToRemove=animalRepository.findById(animalID);
        if(animalToRemove.get()!=null){
            animalRepository.delete(animalToRemove.get());
            return "Animal donated!";
        }
        else {
            return "Animal doesn't exist or has already been sold";
        }
    }


    public Page<Animal> findAllPaged(Pageable pageable) {
        return animalRepository.findAll(pageable);
    }
    public String sellAnimal(String animalName){

        Animal animalToSell=animalRepository.findByNameAndSoldFalse(animalName);
        if(animalToSell!=null){
        animalToSell.setSold(true);
        animalRepository.save(animalToSell);
        return "Animal sold!";
        }
        else {
            return "Animal doesn't exist or has already been sold";
        }
    }

}