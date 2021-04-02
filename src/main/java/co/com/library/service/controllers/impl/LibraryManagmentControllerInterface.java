package co.com.library.service.controllers.impl;

import co.com.library.service.api.request.BookRequest;
import co.com.library.service.api.request.BookingRequest;
import co.com.library.service.api.request.InventoryRequest;
import co.com.library.service.api.request.RateRequest;
import co.com.library.service.api.request.UserRequest;
import co.com.library.service.api.response.BookResponse;
import co.com.library.service.api.response.BookingResponse;
import co.com.library.service.api.response.LoginResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LibraryManagmentControllerInterface {

  @GetMapping("/login/{id}")
  ResponseEntity<LoginResponse> getLogin(@PathVariable(name = "id") int id);

  @PostMapping("/registry")
  Boolean setUser(@Validated @RequestBody UserRequest userRequest) throws Exception;

  @PostMapping("/booking")
  ResponseEntity<BookingResponse> setBooking(@Validated @RequestBody BookingRequest bookingRequest);

  @PutMapping("/updateInventory")
  Boolean updateInventory(@Validated @RequestBody InventoryRequest inventoryRequest);

  @PutMapping("/updateRate")
  Boolean updateRate(@Validated @RequestBody RateRequest rateRequest);

  @GetMapping("/findBooks")
  ResponseEntity<List<BookResponse>> getBook();

  @PostMapping("/addBook")
  Boolean addBook(@Validated @RequestBody BookRequest bookRequest);

  @DeleteMapping("/deleteBook/{id}")
  Boolean deleteBook(@PathVariable(name = "id") int id);
}
