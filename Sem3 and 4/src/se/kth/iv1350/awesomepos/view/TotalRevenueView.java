package se.kth.iv1350.awesomepos.view;

import se.kth.iv1350.awesomepos.model.SaleInterface;

import java.text.DecimalFormat;

public class TotalRevenueView implements SaleInterface {
    DecimalFormat df = new DecimalFormat("###.###");
    private double totalRevenue;

    /**
     * Constructor for the TotalRevenueView-class
     */
    public TotalRevenueView() {
    }
    /**
     * adds total revenue and prints
     *
     * @param revenue is the revenue of the sale
     */
    @Override
    public void newRevenue(double revenue) {
        totalRevenue += revenue;
        printRevenue();
    }

    /**
     * Prints total revenue
     */
    public void printRevenue() {
        System.out.println("-------TotalRevenueView------\nTotal revenue is: " + df.format(totalRevenue) + "\n-----------------------");
    }
}
