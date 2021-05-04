package min.micro.api.user.service;

import min.micro.api.user.domain.UserDto;
import min.micro.api.user.domain.UserVo;

public interface UserService {

    String signup(UserVo user);
    UserDto signin(UserVo user);
}
