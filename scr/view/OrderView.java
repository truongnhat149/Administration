package view;

import service.iinterface.IItemService;
import service.iinterface.IOderService;
import service.iinterface.IOrderItemService;

public class OrderView {
    private IItemService itemService;
    private IOderService iOderService;
    private IOrderItemService iOrderItemService;

    public OrderView(IItemService itemService, IOderService iOderService, IOrderItemService iOrderItemService) {
        this.itemService = itemService;
        this.iOderService = iOderService;
        this.iOrderItemService = iOrderItemService;
    }
    public void showOrder() {

    }
    public void showPaymentsInfo() {

    }
    public void addOrder() {

    }
    public void checkQuantilyOrder() {

    }
}
