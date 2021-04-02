package co.com.library.service.mappers;

import co.com.library.service.api.response.BookResponse;
import co.com.library.service.model.BooksEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-02T00:13:49-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
@Component
public class BookResponseMapperInterfaceImpl implements BookResponseMapperInterface {

    @Override
    public List<BookResponse> map(List<BooksEntity> booksEntityList) {
        if ( booksEntityList == null ) {
            return null;
        }

        List<BookResponse> list = new ArrayList<BookResponse>( booksEntityList.size() );
        for ( BooksEntity booksEntity : booksEntityList ) {
            list.add( bookResponse( booksEntity ) );
        }

        return list;
    }

    @Override
    public BookResponse bookResponse(BooksEntity booksEntity) {
        if ( booksEntity == null ) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        if ( booksEntity.getCuantityAvailable() != null ) {
            bookResponse.setCuantity_available( booksEntity.getCuantityAvailable() );
        }
        if ( booksEntity.getRate() != null ) {
            bookResponse.setRate( booksEntity.getRate() );
        }
        bookResponse.setAuthor( booksEntity.getAuthor() );
        if ( booksEntity.getReservedAmount() != null ) {
            bookResponse.setReserved_amount( booksEntity.getReservedAmount() );
        }
        bookResponse.setId( booksEntity.getId() );
        bookResponse.setCategory( booksEntity.getCategory() );
        bookResponse.setBookName( booksEntity.getBookName() );

        return bookResponse;
    }
}
