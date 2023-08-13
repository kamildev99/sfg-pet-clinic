package kd.springframework.sfgpetclinic.services;

import kd.springframework.sfgpetclinic.model.Owner;
import kd.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
