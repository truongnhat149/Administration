package services;

import model.order.Order;
import services.tools.IOderService;
import utils.file.TextFileUtil;
import utils.json.JacksonParser;

import java.util.ArrayList;
import java.util.List;

public class OderService implements IOderService {
    private static String path = "data/order.json";

    @Override
    public List<Order> getOrders() {
        String jsonString = TextFileUtil.read(path);
        if(jsonString != null && jsonString.trim().length() > 0)
            return JacksonParser.INSTANCE.toList(jsonString, Order.class);
        return new ArrayList<>();
    }

    @Override
    public Order getOrderByID(long id) {
        List<Order> orderList = getOrders();
        for (Order orders : orderList) {
            if (orders.getOrderID() == id) {
                return orders;
            }
        }
        return null;
    }

    @Override
    public void add(Order newOrder) {
        List<Order> orderList = getOrders();
        orderList.add(newOrder);
        String json = JacksonParser.INSTANCE.toJson(orderList);
        TextFileUtil.writeFile(json, path);
    }

    @Override
    public void update() {
        List<Order> orderList = getOrders();
        String json = JacksonParser.INSTANCE.toJson(orderList);
        TextFileUtil.writeFile(json, path);
    }

    @Override
    public void remove(Order order) {
        List<Order> orderList = getOrders();
        orderList.remove(order);
        String json = JacksonParser.INSTANCE.toJson(orderList);
        TextFileUtil.writeFile(json, path);
    }

    @Override
    public boolean exists(long id) {
        return getOrderByID(id) != null;
    }
}
