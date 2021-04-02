package co.com.library.service.repository;

import co.com.library.service.model.BooksEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepositoryInterface extends CrudRepository<BooksEntity, Integer> {}
