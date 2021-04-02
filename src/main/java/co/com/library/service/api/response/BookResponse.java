package co.com.library.service.api.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {

  int id;
  String bookName;
  String author;
  String category;
  int cuantity_available;
  int reserved_amount;
  int rate;
}
