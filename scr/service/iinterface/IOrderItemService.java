package service.iinterface;

import model.order.Order;

import java.util.List;

public interface IOrderItemService {
    List<Order> getOrderService();
    void getOrderItem(int id);
    void add();
}
