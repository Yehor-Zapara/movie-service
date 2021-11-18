package yehor.zapara.spring.dao;

import java.util.List;
import yehor.zapara.spring.model.Order;
import yehor.zapara.spring.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
