package services.tools;

import model.product.Chair;

import java.util.List;

public interface IItemService {
    List<Chair> getItem();
    void addItem(Chair chair);
    void update(Chair chair);
    void remove(long id);
    boolean exists(int id);
    Chair getChairByID(int id);
}
