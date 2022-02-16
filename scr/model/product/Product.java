package model.product;

import model.details.OrderDetails;
import model.order.Prices;

public class Product {
    private int productID;
    private String name;
//    private Prices unitPrice;
    private double unitPrice;
//    private OrderDetails quantily;
    private int quantily;
//    private Providers provideName;
    private String provideName;
//    private ProductTypes productTypeName;
    private String productTypeName;

    public Product(int productID, String name, double unitPrice,
                   int quantily, String provideName, String productTypeName) {
        this.productID = productID;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantily = quantily;
        this.provideName = provideName;
        this.productTypeName = productTypeName;
    }

    public Product(String record) {
        String[] fields = record.split(",");
        productID = Integer.parseInt(fields[0]);
        name = fields[1];
        unitPrice = Double.parseDouble(fields[2]);
        quantily = Integer.parseInt(fields[3]);
        provideName = fields[4];
        productTypeName = fields[5];
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvideName() {
        return provideName;
    }

    public void setProvideName(String provideName) {
        this.provideName = provideName;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantily=" + quantily +
                ", provideName='" + provideName + '\'' +
                ", productTypeName='" + productTypeName + '\'' +
                '}';
    }
}
