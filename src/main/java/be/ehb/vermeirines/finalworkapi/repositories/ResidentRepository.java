package be.ehb.vermeirines.finalworkapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import be.ehb.vermeirines.finalworkapi.model.Resident;


@Repository
public interface ResidentRepository extends CrudRepository<Resident, Long> {
}