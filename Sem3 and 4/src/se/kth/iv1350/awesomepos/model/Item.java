package se.kth.iv1350.awesomepos.model;

import se.kth.iv1350.awesomepos.model.DTO.ItemDTO;

public class Item {

    private final String itemIdentifier;
    private final double price;
    private final String itemDescription;
    private final double VAT;
    private int soldQuantity;

    public Item(ItemDTO item, int soldQuantity) {
        this.itemIdentifier = item.getItemIdentifier();
        this.price = item.getPrice();
        this.itemDescription = item.getItemDescription();
        VAT = item.getVAT();
        this.soldQuantity = soldQuantity;
    }

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public double getPrice() {
        return price;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getVAT() {
        return VAT;
    }


    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", itemDescription='" + itemDescription + '\'' +
                ", VAT=" + VAT +
                ", soldQuantity=" + soldQuantity +
                '}';
    }
}
