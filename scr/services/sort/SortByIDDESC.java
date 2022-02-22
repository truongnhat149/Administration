package services.sort;

import model.product.Chair;
import java.util.Comparator;

public class SortByIDDESC implements Comparator<Chair> {
    @Override
    public int compare(Chair o1, Chair o2) {
        return (int) (o2.getProductID() - o1.getProductID());
    }
}
