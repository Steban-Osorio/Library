package co.com.library.service.api.request;

import java.sql.Date;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {
  @NonNull Date return_date;
  @NonNull int cuantity_books;
  @NonNull int id_user;
  @NonNull int id_book;
}
