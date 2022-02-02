package se.kth.iv1350.awesomepos.model;

import se.kth.iv1350.awesomepos.model.DTO.ItemDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * represents one sale.
 */
public class Sale {
    private  LocalDateTime saleAndDateTime;
    private final ArrayList<Item> itemList = new ArrayList<>();
    private final Receipt receipt;
    private double runningTotal = 0;
    private double amountPaid = 0;
    private double VAT = 0;
    private final List<SaleInterface> saleInterface = new ArrayList<>();
    /**
     * creates a new instance
     */
    public Sale() {
        setDateAndTimeOfSale();
        receipt = new Receipt(this);
    }
    /**
     * a private method that register the Date and Time at the start of the Sale.
     */
    private void setDateAndTimeOfSale() {
        saleAndDateTime = LocalDateTime.now();
    }
    /**
     * Registers the item and quantity sold to the Sales-Log
     *
     * @param item  is the registered item
     * @param quantity is the quantity sold of the item
     */
    public String registerSoldItem(ItemDTO item, int quantity) {
          //  System.out.println("Addin g new item to Sales Log: \n" + item + "\n");
        if (itemExists(item))
            incrementQuantity(item, quantity);
        else
            itemList.add(new Item(item, quantity));
        runningTotal += item.getPrice() * quantity;
        VAT += item.getPrice() * quantity * item.getVAT();

        return displayUpdate(item);
    }

    /**
     * @return returns the running total + VAT
     */
    public double getTotal() {
        return this.runningTotal + this.VAT;
    }

    /**
     * @return all the item in the sale
     */
    public ArrayList<Item> getItemList() {
        return this.itemList;
    }

    /**
     * @return time sale is started
     */
    public LocalDateTime getSaleDateAndTime() {
        return saleAndDateTime;
    }

    /**
     * @return the current receipt
     */
    public Receipt getReceipt() {
        return receipt;
    }

    /**
     * @return running total
     */
    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     * @return amount paid by customer
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Sets the amount customer pays
     *
     * @param amountPaid is the amount customer pays
     */
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * @return amount of VAT
     */
    public double getVAT() {
        return VAT;
    }

    /**
     * @return change for the customer
     */
    public double getChange() {
        return getAmountPaid() - getTotal();
    }

    /**
     * Returns a Description of item and running total
     *
     * @param item is the itemDTO
     * @return info for item and running total
     */
    private String displayUpdate(ItemDTO item) {
        return "Description: " + item.getItemDescription() + "\nPrice: " + item.getPrice() + " $\n" + "Running total: " + runningTotal + " $\n";

    }

    /**
     * Checks if the item exists in current sale
     *
     * @param item is the item
     * @return if a item already exists in the sale
     */
    private boolean itemExists(ItemDTO item) {
        for (Item value : itemList) {
            if (value.getItemIdentifier().equals(item.getItemIdentifier()))
                return true;
        }
        return false;
    }

    /**
     * Adds a item to the sale
     *
     * @param item  the item to be added
     * @param quantity amount added
     */
    private void incrementQuantity(ItemDTO item, int quantity) {
        for (Item value : itemList) {
            if (value.getItemIdentifier().equals(item.getItemIdentifier()))
                value.setSoldQuantity(value.getSoldQuantity() + quantity);
        }
    }

    /**
     * Adds Interfaces and notifies them
     *
     * @param saleInterfaces is the interface to be added
     */
    public void addSaleInterface(List<SaleInterface> saleInterfaces) {
        saleInterface.addAll(saleInterface);
        notifyAllInterfaces();
    }

    /**
     * Adds revenue to Interface
     */
    private void notifyAllInterfaces() {
        for (SaleInterface intrf : saleInterface) {
            intrf.newRevenue(getRunningTotal());
        }
    }
}
