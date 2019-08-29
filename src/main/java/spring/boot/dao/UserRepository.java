package spring.boot.dao;

import org.springframework.data.repository.CrudRepository;
import spring.boot.models.Users;

public interface UserRepository extends CrudRepository<Users, Integer>{

}
