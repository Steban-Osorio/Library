package co.com.library.service.api.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {
  boolean exist;
  int id;
  String typeUser;
  String userName;
  String lastName;
}
