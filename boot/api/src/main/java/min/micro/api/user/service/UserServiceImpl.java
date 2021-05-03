package min.micro.api.user.service;

import lombok.extern.java.Log;


import min.micro.api.user.domain.UserDto;
import org.springframework.stereotype.Service;


@Log
@Service
public class UserServiceImpl implements UserService {

    @Override
    public long signup(UserDto user) {
        return 0;
    }

//    private final UserRepository repo;
//
//
//
//    @Override
//    public String login(String username, String password) throws Exception {
//        return repo.login(username,password);
//    }
//
//    @Override
//    public Optional<User> findByUsername(String username) {
//        return repo.findByUsername(username);
//    }
//
//    @Override
//    public void deleteByUsername(String username) {
//        repo.deleteByUsername(username);
//    }
//
//    @Override
//    public boolean existsByUsername(String username) {
//        return repo.existsByUsername(username);
//    }
//
//    @Override
//    public Long save(User entity) {
//        return (repo.save(entity) != null) ? 1L : 0L;
//    }
//
//    @Override
//    public Optional<User> findById(long id) {
//        return repo.findById(id);
//    }
//
//    @Override
//    public Page<User> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public int count() {
//        return 0;
//    }
//
//    @Override
//    public Optional<User> getOne(long id) {
//        return null;
//    }
//
//    @Override
//    public Long delete(User user) {
//        return null;
//    }
//
//    @Override
//    public Boolean existsById(long id) {
//        return false;
//    }
//
//    @Override
//    public void deleteById(long id) {
//        repo.deleteById(id);
//    }
}
