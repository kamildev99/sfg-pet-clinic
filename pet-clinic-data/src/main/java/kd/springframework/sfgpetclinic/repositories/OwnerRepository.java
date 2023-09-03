package kd.springframework.sfgpetclinic.repositories;

import jakarta.transaction.Transactional;
import kd.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    /*@Query("SELECT DISTINCT owner From Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%")
    @Transactional(readOnly = true)
    Collection<Owner> findByLastName(@Param("lastName") String lastName);

    @Query("Select owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id")
    @Transactional(readOnly = true)
    Owner findById(@Param("id") Integer id);

    void save(Owner owner);*/

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
