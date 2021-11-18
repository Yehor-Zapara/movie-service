package yehor.zapara.spring.service.mapper;

import org.springframework.stereotype.Component;
import yehor.zapara.spring.dto.response.UserResponseDto;
import yehor.zapara.spring.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
