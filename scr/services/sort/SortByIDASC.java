package services.sort;

import model.product.Chair;
import java.util.Comparator;

public class SortByIDASC implements Comparator<Chair> {
    Chair chair = new Chair();
    @Override
    public int compare(Chair o1, Chair o2) {
        return (int) (o1.getProductID() - o2.getProductID());
    }
}
