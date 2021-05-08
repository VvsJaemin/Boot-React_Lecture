package min.micro.api.user.service;

import min.micro.api.user.domain.UserDto;
import min.micro.api.user.domain.UserVo;

import java.util.List;

public interface UserService {

    String signup(UserVo user);
    UserDto signin(UserVo user);
    List<UserVo> findAll();
    List<UserDto>fetch(UserVo user);

}
