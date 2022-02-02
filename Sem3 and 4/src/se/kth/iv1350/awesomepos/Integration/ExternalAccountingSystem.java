package se.kth.iv1350.awesomepos.Integration;

import se.kth.iv1350.awesomepos.model.Sale;
import se.kth.iv1350.awesomepos.model.DTO.SaleDTO;

public class ExternalAccountingSystem {

    public ExternalAccountingSystem(){
    }
   // trying to invoke operation exception
   // public void checkRuningTotlal(double runing total ){
    // if runing talal > Amount paid throw operation excepton.}


    public void storeSaleInformation(Sale sale){
        System.out.println(" Storing the sale ");
    }

    public void logSaleInformation(SaleDTO saleDTO){
        System.out.println( " logging sale information in Accounting system" );
    }
}

