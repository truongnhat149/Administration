package service;

import model.product.Product;
import org.junit.jupiter.api.Test;
import service.iinterface.IItemService;

import java.util.List;

public class ItemService implements IItemService {
    @Override
    public List<Product> getItem() {
        return null;
    }

    @Override
    public void addItem(Product product) {

    }

    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }

    @Override
    public boolean exists(int id) {
        return false;
    }


}
