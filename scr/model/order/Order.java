package model.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long orderID;
    private String name;
    private String phone;
    private String address;

    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {}

    public Order(long orderID, String name, String phone, String address) {
        this.orderID = orderID;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
