package services;

import model.order.OrderItem;
import services.tools.IOrderItemService;
import utils.file.TextFileUtil;
import utils.json.JacksonParser;

import java.util.ArrayList;
import java.util.List;

public class OrderChairService implements IOrderItemService {
    private String path = "data/order-item.json";


    @Override
    public List<OrderItem> getOrderItem() {
        String jStringRead = TextFileUtil.read(path);
        if (jStringRead != null && jStringRead.trim().length() > 0)
          return JacksonParser.INSTANCE.toList(jStringRead, OrderItem.class);
        return new ArrayList<>();
    }

    @Override
    public OrderItem getOrderItemByID(int id) {
        List<OrderItem> orderItemsList = getOrderItem();
        for (OrderItem orderItem : orderItemsList) {
            if (orderItem.getOrderID() == id) {
                return orderItem;
            }
        }
        return null;
    }

    @Override
    public void add(OrderItem newOI) {
        List<OrderItem> orderItemsList = getOrderItem();
        orderItemsList.add(newOI);
        String json = JacksonParser.INSTANCE.toJson(orderItemsList);
        TextFileUtil.writeFile(json, path);
    }

    @Override
    public void update(OrderItem newODI) {
        List<OrderItem> orderItemsList = getOrderItem();
        String json = JacksonParser.INSTANCE.toJson(orderItemsList);
        TextFileUtil.writeFile(json, path);
    }
}
