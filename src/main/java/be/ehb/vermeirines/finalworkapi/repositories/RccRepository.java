package be.ehb.vermeirines.finalworkapi.repositories;

import be.ehb.vermeirines.finalworkapi.model.ResidentialCareCenter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RccRepository extends CrudRepository<ResidentialCareCenter, Long> {
    ResidentialCareCenter findResidentialCareCenterByUsernameEqualsAndPasswordEquals (String username, String password);
}
