package yehor.zapara.spring.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import yehor.zapara.spring.dto.response.ShoppingCartResponseDto;
import yehor.zapara.spring.model.ShoppingCart;
import yehor.zapara.spring.model.Ticket;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
