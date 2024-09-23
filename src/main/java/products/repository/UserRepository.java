package products.repository;

import org.springframework.data.repository.CrudRepository;
import products.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
