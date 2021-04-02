package co.com.library.service.api.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {
  boolean isBooking;
  Long rate;
}
