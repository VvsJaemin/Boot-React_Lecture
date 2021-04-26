package min.micro.api.user.service;

import min.micro.api.user.domain.User;

import java.util.Optional;

 interface UserSevice {

    String login(String username, String password)throws Exception;

    Optional<User> findByUsername (String username);

    void deleteByUsername (String username);

    boolean existsByUsername(String username);

}