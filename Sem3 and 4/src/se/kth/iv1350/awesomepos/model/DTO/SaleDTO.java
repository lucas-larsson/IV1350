package se.kth.iv1350.awesomepos.model.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.iv1350.awesomepos.model.Item;
import se.kth.iv1350.awesomepos.model.Receipt;
import se.kth.iv1350.awesomepos.model.Sale;

public class SaleDTO {
        private final ArrayList<Item> itemList;
        private final LocalDateTime saleDateAndTime;
        private final Receipt receipt;
        private final double runningTotal;
        private final double amountPaid;
        private final double VAT;

        /**
         * Creates a new instance
         *
         * @param sale is the current Sale object
         */
    public SaleDTO(Sale sale) {
            this.itemList = sale.getItemList();
            this.saleDateAndTime = sale.getSaleDateAndTime();
            this.receipt = sale.getReceipt();
            this.runningTotal = sale.getRunningTotal();
            this.amountPaid = sale.getAmountPaid();
            this.VAT = sale.getVAT();
        }

        /**
         * @return returns the running total + VAT
         */
        public double getTotal() {
            return this.runningTotal + this.VAT;
        }

        /**
         * @return all the products in the sale
         */
        public ArrayList<Item> getItemList() {
            return itemList;
        }

        /**
         * @return time sale is started
         */
        public LocalDateTime getSaleDateAndTime() {
            return saleDateAndTime;
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
         * @return amount of VAT
         */
        public double getVAT() {
            return VAT;
        }
}
