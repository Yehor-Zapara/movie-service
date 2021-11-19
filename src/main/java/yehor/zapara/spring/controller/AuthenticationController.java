package yehor.zapara.spring.controller;

import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yehor.zapara.spring.dto.request.UserRequestDto;
import yehor.zapara.spring.dto.response.UserResponseDto;
import yehor.zapara.spring.model.User;
import yehor.zapara.spring.service.AuthenticationService;
import yehor.zapara.spring.service.mapper.UserMapper;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public String startPage(Authentication auth) {
        return String.format("Hello %s, nice to see you in our movie service)", auth.getName());
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return userMapper.mapToDto(user);
    }
}
