package min.micro.api.user.service;

import min.micro.api.user.domain.UserDto;

public interface UserService {

    long signup(UserDto user);
}
