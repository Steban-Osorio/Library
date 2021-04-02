package co.com.library.service.repository;

import co.com.library.service.model.ReserveEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReserveRepositoryInterface extends CrudRepository<ReserveEntity, Integer> {}
