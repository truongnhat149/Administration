package model.product;

public class Chair {
    private long productID;
    private String name;
    private double price;
    private int quantity;
    private String providerName;

    public Chair() {}
    public Chair(long productID, String name, double price,
                 int quantity, String providerName) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.providerName = providerName;
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

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvideName() {
        return providerName;
    }

    public void setProvideName(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", unitPrice=" + price +
                ", quantity=" + quantity +
                ", provideName='" + providerName + '\'' +
                '}';
    }
}
