package co.com.library.service.mappers;

import co.com.library.service.api.response.BookResponse;
import co.com.library.service.model.BooksEntity;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface BookResponseMapperInterface {

  @IterableMapping(qualifiedByName = "bookResponse")
  List<BookResponse> map(List<BooksEntity> booksEntityList);

  @Named("bookResponse")
  @Mapping(source = "booksEntity.id", target = "id")
  @Mapping(source = "booksEntity.bookName", target = "bookName")
  @Mapping(source = "booksEntity.author", target = "author")
  @Mapping(source = "booksEntity.category", target = "category")
  @Mapping(source = "booksEntity.cuantityAvailable", target = "cuantity_available")
  @Mapping(source = "booksEntity.reservedAmount", target = "reserved_amount")
  @Mapping(source = "booksEntity.rate", target = "rate")
  BookResponse bookResponse(BooksEntity booksEntity);
}
