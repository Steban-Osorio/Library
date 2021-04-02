package co.com.library.service.mappers;

import co.com.library.service.api.response.LoginResponse;
import co.com.library.service.model.UsersEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-02T00:13:49-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
@Component
public class LoginResponseMapperInterfaceImpl implements LoginResponseMapperInterface {

    @Override
    public LoginResponse loginResponse(UsersEntity usersEntity) {
        if ( usersEntity == null ) {
            return null;
        }

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setLastName( usersEntity.getLastName() );
        loginResponse.setId( usersEntity.getId() );
        loginResponse.setTypeUser( usersEntity.getTypeUser() );
        loginResponse.setUserName( usersEntity.getUserName() );

        return loginResponse;
    }
}
