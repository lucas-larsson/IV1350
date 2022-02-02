package se.kth.iv1350.awesomepos.Integration;

import se.kth.iv1350.awesomepos.model.DTO.SaleDTO;

public class Register {

    public Register(){

    }
    private double amount = 0 ;
    public void increaseRegisterAmount(SaleDTO saleDTO) {

        this.amount += saleDTO.getTotal();
        System.out.println("Totla Amuount in Register is "+ this.amount+ "$");
    }

}
