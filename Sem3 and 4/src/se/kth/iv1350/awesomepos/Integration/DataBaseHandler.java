package se.kth.iv1350.awesomepos.Integration;
import se.kth.iv1350.awesomepos.model.DTO.SaleDTO;
import se.kth.iv1350.awesomepos.model.DTO.ItemDTO;



    /**
     * @author LUCAS LARSSON
     *
     * Representing a "controller" which is responsible for all communication between databases and sends
     * it to the Controller-class
     */
    public class DataBaseHandler {
        private final ExternalInventorySystem externalInventorySystem;
        private final ExternalAccountingSystem externalAccountingSystem;
        private final Register register;
        private final Printer printer;

        /**
         * Creates a new instance of the DataBaseHandler
         */
        public DataBaseHandler() {
            externalInventorySystem = new ExternalInventorySystem();
            externalAccountingSystem  = new ExternalAccountingSystem();
            register = new Register();
            printer = new Printer();
        }

        /**
         * Fetches the ProductDTO with the corresponing inputed itemIdentifier
         *
         * @param itemIdentifier uniqe item-ID
         * @return ProductDTO from the Inventory System with the corresponding itemIdentifier
         */
        public ItemDTO getItem(String itemIdentifier) throws InvalidIdentifierException, ConnectivityException {
         // System.out.println("Fetching item info from the InventorySystem.");
            return externalInventorySystem.getItem(itemIdentifier);
        }

        /**
         * Logs the sale in all external systems
         *
         * @param saleDTO is a DTO of class Sale
         */
        public void logSale(SaleDTO saleDTO) {
            externalAccountingSystem.logSaleInformation(saleDTO);
            register.increaseRegisterAmount(saleDTO);

        }

        /**
         * Prints the receipt for current sale
         *
         * @param saleDTO is a DTO of class Sale
         */
        public void printReceipt(SaleDTO saleDTO) {
            printer.print(saleDTO);
        }
    }

