package yehor.zapara.spring.service;

import yehor.zapara.spring.model.MovieSession;
import yehor.zapara.spring.model.ShoppingCart;
import yehor.zapara.spring.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
