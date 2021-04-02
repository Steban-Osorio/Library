package co.com.library.service.api.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {
  @NonNull String bookName;
  @NonNull String author;
  @NonNull String category;
  @NonNull int cuantity_available;
  @NonNull int reserved_amount;
  @NonNull int rate;
}
