package se.kth.iv1350.awesomepos.Integration;

import se.kth.iv1350.awesomepos.model.DTO.SaleDTO;

public class Printer {
    public Printer(){

    }
    public void print (SaleDTO saleDTO) {
        System.out.println("Printing Receipt . . . ");
        System.out.println(saleDTO.getReceipt());
    }
}
