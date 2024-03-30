package com.example.demo;

import com.example.demo.Entities.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByName(String name);

    Animal findByNameAndSoldFalse(String name);

    Page<Animal> findAll(Pageable pageable);

    @Query("SELECT a FROM Animal a WHERE a.species = 'cat' AND a.isSold = false ORDER BY a.price LIMIT 3")
    List<Animal> findFirstThreeUnsoldCats();

    @Modifying
    @Query("UPDATE Animal a SET a.sold = true WHERE a.species = 'cat' AND a.sold = false ORDER BY a.id")
    void updateFirstThreeUnsoldCats();

    @Modifying
    @Query("DELETE FROM Animal a WHERE a.species = 'cat' AND a.sold = false ORDER BY a.id")
    void deleteFirstThreeUnsoldCats();

}
