package min.micro.api.user.controller;

import io.swagger.annotations.*;
import min.micro.api.user.domain.UserDto;
import min.micro.api.user.domain.UserVo;
import min.micro.api.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "users")
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper; // 프론트 ModelMapper

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access Denied"),
            @ApiResponse(code = 422, message = "Invaild username/password supplied")})
    public ResponseEntity<String> signup(@ApiParam("Signup User") @RequestBody UserDto user) {
        System.out.println("회원 가입"+user.toString());
        return ResponseEntity.ok(userService.signup(modelMapper.map(user, UserVo.class))); // 컴파일 이후에 연결(after mapping)
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${UserController.signin}", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 422, message = "Invaild username/password supplied")})
    public ResponseEntity<UserDto> signin(@ApiParam("signin User") @RequestBody UserDto user) {
        System.out.println("로그인"+user.toString());
        return ResponseEntity.ok(userService.signin(modelMapper.map(user, UserVo.class))); // 컴파일 이후에 연결(after mapping)
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserVo>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserVo>> all() {
        log.info("로그인 하지 않은 사용자도 접근 가능한 URI");
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> auth(@PathVariable String username) {
        log.info("로그인한 사용자만 접근 가능한 URI");
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{admin}")
    public ResponseEntity<?> admin() {
        log.info("관리자만 접근 가능한 URI");
        return ResponseEntity.ok(null);
    }
//
//    private final UserServiceImpl service;
//
//
//    @PostMapping("")
//    public ResponseEntity<?> save(@Validated @RequestBody User user) {
//        log.info("회원 가입 완료");
//        service.save(user);
//
//        log.info("Register user.getUserNo() = " + user.getUserNo());
//
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@Valid @RequestBody User user)throws Exception {
//
//        String login = service.login(user.getUsername(), user.getPassword());
//
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
//
//        if (login != null) {
//            log.info("로그인 성공");
//            System
//                    .out
//                    .println("login 세션 확인 : " + login);
//            return new ResponseEntity<>(login, HttpStatus.OK);
//        } else {
//            log.info("다시 로그인 해주세요");
//            return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
//        }
//
//    }
//
//    @GetMapping("/read/{username}")
//    public ResponseEntity<Optional<User>> read(
//            @PathVariable("username")String username
//    ) {
//        log.info("read()");
//        Optional<User> u = service.findByUsername(username);
//        return new ResponseEntity<>(u, HttpStatus.OK);
//    }
//
//    @PutMapping("/modify/{username}")
//    public ResponseEntity<User> modify(
//            @PathVariable("username")String username,
//            @RequestBody User user
//    ) {
//
//        log.info("put modify()" + user);
//
//        log.info("username : " + username);
//        service.save(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{username}")
//    public ResponseEntity<String> remove(@PathVariable String username) {
//
//        service.deleteByUsername(username);
//        log.info("delete");
//
//        return new ResponseEntity<>("delete success!", HttpStatus.NO_CONTENT);
//    }
}
