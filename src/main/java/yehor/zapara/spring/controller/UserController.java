package yehor.zapara.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yehor.zapara.spring.dto.response.UserResponseDto;
import yehor.zapara.spring.exception.DataProcessingException;
import yehor.zapara.spring.model.User;
import yehor.zapara.spring.service.UserService;
import yehor.zapara.spring.service.mapper.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("User with email " + email + " not found"));
        return userMapper.mapToDto(user);
    }
}
