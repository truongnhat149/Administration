package services.tools;

import model.order.Order;

import java.util.List;

public interface IOderService {
    List<Order> getOrders();
    Order getOrderByID(long id);
    void add(Order newOrder);
    void remove(Order order);
    void update();
    boolean exists(long id);
}
