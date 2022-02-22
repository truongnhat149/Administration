package services.sort;

import model.product.Chair;
import java.util.Comparator;

public class SortByPriceDESC implements Comparator<Chair> {
    @Override
    public int compare(Chair o1, Chair o2) {
            if(o2.getPrice() > o1.getPrice()){
                return 1;
            }else if(o1.getPrice() == o2.getPrice()){
                return 0;
            }else{
                return -1;
            }
        }
}
