package se.kth.iv1350.awesomepos.model.DTO;

public class ItemDTO {


    private final String itemIdentifier;
    private final double price;
    private final String itemDescription;
    private final double VAT;
    private final int soldQuantity;

    /**
     * Constructor for ProductDTO
     *
     * @param itemIdentifier  identifies the item with a unique combination of numbers
     * @param price           is the set price of the product
     * @param itemDescription is a description of the product
     * @param VAT             is the VAT rate based on the product
     * @param soldQuantity    is the quantity sold of the product
     */
    public ItemDTO(String itemIdentifier, double price, String itemDescription, double VAT, int soldQuantity) {
        this.itemIdentifier = itemIdentifier;
        this.price = price;
        this.itemDescription = itemDescription;
        this.VAT = VAT;
        this.soldQuantity = soldQuantity;
    }

    /**
     * @return the unique itemIdentifier
     */
    public String getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * @return the specific price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * @return the VAT-rate for the item
     */
    public double getVAT() {
        return VAT;
    }

    /**
     * @return the quantity sold
     */
    public int getSoldQuantity() {
        return soldQuantity;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "itemIdentifier='" + itemIdentifier + '\'' +
                ", price=" + price +
                ", itemDescription='" + itemDescription + '\'' +
                ", VAT=" + VAT +
                ", soldQuantity=" + soldQuantity +
                '}';
    }
}
