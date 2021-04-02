package co.com.library.service.mappers;

import co.com.library.service.api.response.LoginResponse;
import co.com.library.service.model.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface LoginResponseMapperInterface {

  @Named("loginResponse")
  @Mapping(source = "usersEntity.id", target = "id")
  @Mapping(source = "usersEntity.typeUser", target = "typeUser")
  @Mapping(source = "usersEntity.lastName", target = "lastName")
  LoginResponse loginResponse(UsersEntity usersEntity);
}
