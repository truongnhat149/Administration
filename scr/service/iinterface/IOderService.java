package service.iinterface;

import model.order.Order;

import java.util.List;

public interface IOderService {
    List<Order> getOrders();
    void getOrderByID(int id);
    void add(Order newOrder);
    void remove(Order order);
    void update();
    void exists(int id);
}
