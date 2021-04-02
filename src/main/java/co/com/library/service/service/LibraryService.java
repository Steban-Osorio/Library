package co.com.library.service.service;

import co.com.library.service.api.request.BookRequest;
import co.com.library.service.api.request.BookingRequest;
import co.com.library.service.api.request.InventoryRequest;
import co.com.library.service.api.request.RateRequest;
import co.com.library.service.api.request.UserRequest;
import co.com.library.service.api.response.BookResponse;
import co.com.library.service.api.response.BookingResponse;
import co.com.library.service.api.response.LoginResponse;
import co.com.library.service.mappers.BookResponseMapperInterface;
import co.com.library.service.mappers.LoginResponseMapperInterface;
import co.com.library.service.model.BooksEntity;
import co.com.library.service.model.ReserveEntity;
import co.com.library.service.model.UsersEntity;
import co.com.library.service.repository.BooksRepositoryInterface;
import co.com.library.service.repository.ReserveRepositoryInterface;
import co.com.library.service.repository.UserRepositoryInterface;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

  @Autowired BooksRepositoryInterface booksRepositoryInterface;
  @Autowired ReserveRepositoryInterface reserveRepositoryInterface;
  @Autowired UserRepositoryInterface userRepositoryInterface;

  private final LoginResponseMapperInterface loginResponseMapperInterface;

  private final BookResponseMapperInterface bookResponseMapperInterface;

  public LibraryService(
      LoginResponseMapperInterface loginResponseMapperInterface,
      BookResponseMapperInterface bookResponseMapperInterface) {
    this.loginResponseMapperInterface = loginResponseMapperInterface;
    this.bookResponseMapperInterface = bookResponseMapperInterface;
  }

  public LoginResponse getLogin(int id) {
    LoginResponse loginResponse = new LoginResponse();
    Optional<UsersEntity> optionalUsersEntity = userRepositoryInterface.findById(id);
    if (optionalUsersEntity.isPresent()) {
      UsersEntity usersEntity = optionalUsersEntity.get();
      loginResponse = loginResponseMapperInterface.loginResponse(usersEntity);
      loginResponse.setExist(true);
    }
    return loginResponse;
  }

  public Boolean setUser(UserRequest userRequest) throws Exception {
    boolean valid;
    try {
      UsersEntity usersEntity = new UsersEntity();
      usersEntity.setId(userRequest.getId());
      usersEntity.setTypeUser(userRequest.getTypeUser());
      usersEntity.setUserName(userRequest.getUserName());
      usersEntity.setLastName(userRequest.getLastName());
      userRepositoryInterface.save(usersEntity);
      valid = true;
    } catch (Exception e) {
      valid = false;
    }
    return valid;
  }

  public BookingResponse setBooking(BookingRequest bookingRequest) {
    BookingResponse bookingResponse = new BookingResponse();
    boolean valid;
    try {
      ReserveEntity reserveEntity = new ReserveEntity();
      reserveEntity.setReturnDate((Date) bookingRequest.getReturn_date());
      reserveEntity.setCuantityBooks(bookingRequest.getCuantity_books());
      reserveEntity.setIdUser(bookingRequest.getId_user());
      reserveEntity.setIdBook(bookingRequest.getId_book());
      reserveRepositoryInterface.save(reserveEntity);
      valid = true;
    } catch (Exception e) {
      valid = false;
    }
    bookingResponse.setBooking(valid);
    bookingResponse.setRate(
        getRate(bookingRequest.getId_book(), bookingRequest.getCuantity_books()));
    return bookingResponse;
  }

  public Boolean updateInventory(InventoryRequest inventoryRequest) {
    boolean valid = false;
    int cuantity;
    try {
      Optional<BooksEntity> optionalBooksEntity =
          booksRepositoryInterface.findById(inventoryRequest.getId_book());
      if (optionalBooksEntity.isPresent()) {
        BooksEntity booksEntity = new BooksEntity();
        booksEntity = optionalBooksEntity.get();
        cuantity = booksEntity.getCuantityAvailable();
        cuantity += inventoryRequest.getCuantity();
        booksEntity.setCuantityAvailable(cuantity);
        booksRepositoryInterface.save(booksEntity);
        valid = true;
      }
    } catch (Exception e) {
      valid = false;
    }
    return valid;
  }

  public Boolean updateRate(RateRequest rateRequest) {
    boolean valid = false;
    try {
      Optional<BooksEntity> optionalBooksEntity =
          booksRepositoryInterface.findById(rateRequest.getId_book());
      if (optionalBooksEntity.isPresent()) {
        BooksEntity booksEntity = new BooksEntity();
        booksEntity = optionalBooksEntity.get();
        booksEntity.setRate((int) (long) rateRequest.getRate());
        booksRepositoryInterface.save(booksEntity);
        valid = true;
      }
    } catch (Exception e) {
      valid = false;
    }
    return valid;
  }

  public List<BookResponse> getBook() {
    List<BooksEntity> listBooksEntities = (List<BooksEntity>) booksRepositoryInterface.findAll();
    List<BookResponse> listBookResponse = bookResponseMapperInterface.map(listBooksEntities);
    return listBookResponse;
  }

  public Boolean addBook(BookRequest bookRequest) {
    boolean valid = false;
    try {
      BooksEntity booksEntity = new BooksEntity();
      booksEntity.setBookName(bookRequest.getBookName());
      booksEntity.setAuthor(bookRequest.getAuthor());
      booksEntity.setCategory(bookRequest.getCategory());
      booksEntity.setRate(bookRequest.getRate());
      booksEntity.setCuantityAvailable(bookRequest.getCuantity_available());
      booksEntity.setReservedAmount(bookRequest.getReserved_amount());
      booksRepositoryInterface.save(booksEntity);
      valid = true;
    } catch (Exception e) {
      valid = false;
    }
    return valid;
  }

  public Boolean deleteBook(int id) {
    boolean valid = false;
    try {
      booksRepositoryInterface.deleteById(id);
      valid = true;
    } catch (Exception e) {
      valid = false;
    }
    return valid;
  }

  private Long getRate(int idBook, int cuantity) {
    long rate = 0;
    Optional<BooksEntity> optionalBooksEntity = booksRepositoryInterface.findById(idBook);
    if (optionalBooksEntity.isPresent()) {
      BooksEntity booksEntity = new BooksEntity();
      booksEntity = optionalBooksEntity.get();
      rate = booksEntity.getRate() * cuantity;
    }
    return rate;
  }
}
