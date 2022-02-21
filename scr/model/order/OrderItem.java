package model.order;

public class OrderItem {
    private long id;
    private long orderID;
    private long chairID;
    private String chairName;
    private double price;
    private int quantity;
    private double total;

    public OrderItem() {
    }

    public OrderItem(long id, long orderID, long chairID, String chairName, double price, int quantity, double total) {
        this.id = id;
        this.orderID = orderID;
        this.chairID = chairID;
        this.chairName = chairName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getChairID() {
        return chairID;
    }

    public void setChairID(long chairID) {
        this.chairID = chairID;
    }

    public String getChairName() {
        return chairName;
    }

    public void setChairName(String chairName) {
        this.chairName = chairName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderID=" + orderID +
                ", chairID=" + chairID +
                ", chairName='" + chairName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
