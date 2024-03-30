package com.example.demo;

import com.example.demo.Entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/petShopAPI")
public class AnimalController {

    AnimalService animalService;
    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping("/getAnimals")
    public List<Animal> getAnimals()
    {

        return animalService.getAnimals();

    }

    @PostMapping("/buyAnimal")
    public void buyAnimal(@RequestParam(name="name", required=true)String name,
                          @RequestParam(name="species", required=true)String species,
                          @RequestParam(name="price", required=true) double price )
    {
        animalService.buyAnimal(name, species, price);
    }

    @PutMapping("/sellAnimal")
    public String sellAnimal(@RequestParam(name="name", required=true)String animalName)
    {
       return animalService.sellAnimal(animalName);
    }

    @DeleteMapping("/removeAnimalFromInventory")
    public String removeAnimal(@RequestParam(name="id", required=true)long animalID)
    {
      return animalService.removeAnimal(animalID);
    }

    @GetMapping("/paged")
    public Page<Animal> getAnimalsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return animalService.findAllPaged(pageable);
    }
}