package co.com.library.service.api.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
  @NonNull int id;
  @NonNull String typeUser;
  @NonNull String userName;
  @NonNull String lastName;
}
