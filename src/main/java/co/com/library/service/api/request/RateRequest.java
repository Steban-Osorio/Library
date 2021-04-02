package co.com.library.service.api.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateRequest {
  @NonNull int id_book;
  @NonNull Long rate;
}
