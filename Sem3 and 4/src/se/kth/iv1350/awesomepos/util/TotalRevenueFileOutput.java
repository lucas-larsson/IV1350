package se.kth.iv1350.awesomepos.util;

import se.kth.iv1350.awesomepos.model.SaleInterface;

import java.text.DecimalFormat;

public class TotalRevenueFileOutput implements SaleInterface {
    private final FileLogger logger = new FileLogger("total_revenue.txt");
    DecimalFormat df = new DecimalFormat("###.###");
    private double totalRevenue;

    /**
     * adds total revenue
     *
     * @param revenue is the revenue of the sale
     */
    @Override
    public void newRevenue(double revenue) {
        totalRevenue += revenue;
        logRevenue();
    }

    /**
     * Logs total revenue
     */
    private void logRevenue() {
        logger.log("Total revenue is: " + df.format(totalRevenue));
    }

}
