package co.com.library.service.repository;

import co.com.library.service.model.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryInterface extends CrudRepository<UsersEntity, Integer> {}
