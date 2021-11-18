package yehor.zapara.spring.service;

import java.util.List;
import yehor.zapara.spring.model.Order;
import yehor.zapara.spring.model.ShoppingCart;
import yehor.zapara.spring.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
