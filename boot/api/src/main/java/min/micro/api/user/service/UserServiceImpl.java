package min.micro.api.user.service;

import lombok.RequiredArgsConstructor;

import lombok.extern.java.Log;
import min.micro.api.security.domain.SecurityProvider;
import min.micro.api.security.exception.SecurityRuntimeException;
import min.micro.api.user.domain.Role;
import min.micro.api.user.domain.UserDto;
import min.micro.api.user.domain.UserVo;
import min.micro.api.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Log
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;
    private final ModelMapper modelMapper;

    @Override
    public String signup(UserVo user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            user.setRoles(list);
            userRepository.save(user);
            return provider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public UserDto signin(UserVo user) {
        try {
            UserVo loginedUser = userRepository.signin(user.getUsername(), user.getPassword());
            UserDto userDto = modelMapper.map(user, UserDto.class);
            String token = provider.createToken(user.getUsername(),
                    userRepository.findByUsername(user.getUsername()).getRoles());
            log.info("ISSUED TOKEN :::::::: " + token);
            userDto.setToken(token);
            return userDto;

        } catch (Exception e) {
            throw new SecurityRuntimeException("Invalid Username / Password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
            // 보안성 향상 - vo를 감싸기 위해 모델 맵퍼를 사용하여 dto로 던진다.
    }

    @Override
    public List<UserVo> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDto> fetch(UserVo user) {
        return userRepository.findAll().stream().map(u->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }


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

