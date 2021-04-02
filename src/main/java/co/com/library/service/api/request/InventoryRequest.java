package co.com.library.service.api.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InventoryRequest {
  @NonNull int id_book;
  @NonNull int cuantity;
}
