package Dev.Arip.BookMyShow.controller;

import Dev.Arip.BookMyShow.dtos.UserLoginDTO;
import Dev.Arip.BookMyShow.dtos.UserSignUpRequestDTO;
import Dev.Arip.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO) throws Exception {
        return ResponseEntity.ok(
                userService.signUp(userSignUpRequestDTO.getName(), userSignUpRequestDTO.getEmail(), userSignUpRequestDTO.getPwd()));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDTO loginDTO) throws Exception {
        return ResponseEntity.ok(
                        userService.login(loginDTO.getEmail(),loginDTO.getPwd())
                );
    }

}
