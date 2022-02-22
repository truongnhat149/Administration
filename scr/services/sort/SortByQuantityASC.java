package services.sort;

import model.product.Chair;

import java.util.Comparator;

public class SortByQuantityASC implements Comparator<Chair> {
    @Override
    public int compare(Chair o1, Chair o2) {
        return o1.getQuantity() - o2.getQuantity();
    }
}
