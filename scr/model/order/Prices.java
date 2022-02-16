package model.order;

public class Prices {
    private int priceID;
    private int productID;
    private double unitPrice;

    public Prices(int priceID, int productID, double unitPrice) {
        this.priceID = priceID;
        this.productID = productID;
        this.unitPrice = unitPrice;
    }

    public int getPriceID() {
        return priceID;
    }

    public void setPriceID(int priceID) {
        this.priceID = priceID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
