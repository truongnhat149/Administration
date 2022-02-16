package service.iinterface;

import model.product.Product;

import java.util.List;

public interface IItemService {
    List<Product> getItem();
    void addItem(Product product);
    void update();
    void remove();
    boolean exists(int id);

}
