package be.ehb.vermeirines.finalworkapi.repositories;

import be.ehb.vermeirines.finalworkapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsernameEqualsAndPasswordEquals(String username, String password);
}
