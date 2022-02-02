package se.kth.iv1350.awesomepos.controller;

import se.kth.iv1350.awesomepos.Integration.*;
import se.kth.iv1350.awesomepos.model.DTO.*;
import se.kth.iv1350.awesomepos.model.Sale;
import se.kth.iv1350.awesomepos.model.SaleInterface;

import java.util.ArrayList;
import java.util.List;

/**     @author LUCAS LARSSON
 *
 *   This controller class is the only one for the application, all method calls pass through it.
 */


public class Controller {
    private Sale sale;
    private final DataBaseHandler dbHandler;
    private final List<SaleInterface> saleInterfaces = new ArrayList<>();

    /**
     * Start a new sale. This is the first method called in the application.
     */
    public void startSale() {
        sale = new Sale();
    }
    /**
     * this method registers items
     * @param itemIdentifier a sting of characters to identify the item by
     * @param quantity represents the quantity of the registered item
     */
    public String registerItem(String itemIdentifier, int quantity)throws InvalidIdentifierException, ConnectivityException, OperationException {
        ItemDTO item = dbHandler.getItem(itemIdentifier);
        return sale.registerSoldItem(item, quantity);
    }
    /**
     * this method gets the running total
     * @return running total
     */
    public double getTotal() {
        sale.addSaleInterface(saleInterfaces);
        return sale.getTotal();
    }

    /**
     * this method concludes the sale
     * @param paidAmount the amount paid by the customer
     */
    public void concludeSale(double paidAmount) {
        sale.setAmountPaid(paidAmount);
        SaleDTO saleDTO = new SaleDTO(sale);
        dbHandler.logSale(saleDTO);
        dbHandler.printReceipt(saleDTO);
    }

    /**
     *
     */
    public void addSaleInterface(SaleInterface intrf) {

        saleInterfaces.add(intrf);
    }

    /**
     *
     * @param dbHandler handles the data base calls
     */
    public Controller(DataBaseHandler dbHandler) {

        this.dbHandler = dbHandler;
    }
}
