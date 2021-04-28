package min.micro.api.user.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;


import min.micro.api.cmm.service.AbstractService;
import min.micro.api.user.domain.User;
import min.micro.api.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Log
@Service
@AllArgsConstructor
public class UserServiceImpl extends AbstractService<User> implements UserSevice {

    private final UserRepository repo;



    @Override
    public String login(String username, String password) throws Exception {
        return repo.login(username,password);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        repo.deleteByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repo.existsByUsername(username);
    }

    @Override
    public User save(User entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<User> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public User getOne(long id) {
        return null;
    }

    @Override
    public Long delete(User user) {
        return null;
    }

    @Override
    public Boolean existsById(long id) {
        return false;
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }
}
