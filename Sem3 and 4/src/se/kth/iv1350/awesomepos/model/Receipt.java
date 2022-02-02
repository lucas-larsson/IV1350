package se.kth.iv1350.awesomepos.model;

/**
 * this class represents a receipt, it contains all the methods required in the seminar 1,
 * and serve to prove payment.
*/
public class  Receipt {
     private final Sale sale;

     /**
      * Creates a new instance
      *
      * @param sale is the current expiring sale
      */
     public Receipt(Sale sale) {
          this.sale = sale;
     }

     @Override
     public String toString() {
          return "Receipt{" +
                  "\nSale start at: " + sale.getSaleDateAndTime() +
                  "\nitems=" + sale.getItemList() +
                  "\nTotal amount= " + sale.getRunningTotal() + " $ + " + sale.getVAT() + " $ VAT" + " = " + sale.getTotal() + " $" +
                  "\nAmount Paid by customer= " + sale.getAmountPaid() + " $" +
                  "\n Change= " + sale.getChange() + " $ " +
                  '}';
     }
}
