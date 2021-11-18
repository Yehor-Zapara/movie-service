package yehor.zapara.spring.dao;

import yehor.zapara.spring.model.ShoppingCart;
import yehor.zapara.spring.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
