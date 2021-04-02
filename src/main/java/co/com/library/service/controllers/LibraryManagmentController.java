package co.com.library.service.controllers;

import co.com.library.service.api.request.BookRequest;
import co.com.library.service.api.request.BookingRequest;
import co.com.library.service.api.request.InventoryRequest;
import co.com.library.service.api.request.RateRequest;
import co.com.library.service.api.request.UserRequest;
import co.com.library.service.controllers.impl.LibraryManagmentControllerInterface;
import co.com.library.service.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LibraryManagmentController implements LibraryManagmentControllerInterface {

  private final LibraryService libraryService;

  public LibraryManagmentController(LibraryService libraryService) {
    this.libraryService = libraryService;
  }

  @Override
  public ResponseEntity getLogin(int id) {
    return ResponseEntity.ok().body(libraryService.getLogin(id));
  }

  @Override
  public Boolean setUser(UserRequest userRequest) throws Exception {
    return libraryService.setUser(userRequest);
  }

  @Override
  public ResponseEntity setBooking(BookingRequest bookingRequest) {
    return ResponseEntity.ok().body(libraryService.setBooking(bookingRequest));
  }

  @Override
  public Boolean updateInventory(InventoryRequest inventoryRequest) {
    return libraryService.updateInventory(inventoryRequest);
  }

  @Override
  public Boolean updateRate(RateRequest rateRequest) {
    return libraryService.updateRate(rateRequest);
  }

  @Override
  public ResponseEntity getBook() {
    return ResponseEntity.ok().body(libraryService.getBook());
  }

  @Override
  public Boolean addBook(BookRequest bookRequest) {
    return libraryService.addBook(bookRequest);
  }

  @Override
  public Boolean deleteBook(int id) {
    return libraryService.deleteBook(id);
  }
}
