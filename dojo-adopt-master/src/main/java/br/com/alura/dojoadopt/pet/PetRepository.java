package br.com.alura.dojoadopt.pet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PetRepository extends JpaRepository<Pet, Long> {
    boolean existsByNameAndType(String name, Type type);
    List<Pet> findAllByAdoptedIsTrue();

}
