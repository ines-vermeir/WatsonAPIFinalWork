package be.ehb.vermeirines.finalworkapi.repositories;

import be.ehb.vermeirines.finalworkapi.model.CCUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CCUserRepository extends CrudRepository<CCUser, Long> {
}