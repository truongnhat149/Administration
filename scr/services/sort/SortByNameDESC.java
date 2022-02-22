package services.sort;

import model.product.Chair;

import java.util.Comparator;

public class SortByNameDESC implements Comparator<Chair> {
    @Override
    public int compare(Chair o1, Chair o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
