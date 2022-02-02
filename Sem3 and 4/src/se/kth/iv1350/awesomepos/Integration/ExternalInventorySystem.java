package se.kth.iv1350.awesomepos.Integration;

import se.kth.iv1350.awesomepos.model.DTO.ItemDTO;

public class ExternalInventorySystem {

        //represents a mock of the external inventory
        private final ItemDTO[] inventory = new ItemDTO[10];

        /**
         * Creates a new instance
         */
    public ExternalInventorySystem() {
            this.inventory[0] = new ItemDTO("123456", 69, "MacBook Pro Ultra Max", 0.25F, 0);
            this.inventory[1] = new ItemDTO("123457", 420, "Ipad Pro Ultra Super Duper", 0.25F, 0);
            this.inventory[2] = new ItemDTO("123458", 12000, "Lamborghini headlights", 0.30F, 0);
            this.inventory[3] = new ItemDTO("123459", 10, "Soya milk", 0.12F, 0);
            this.inventory[4] = new ItemDTO("123460", 20, "Regular milk", 0.12F, 0);

        }

        /**
         * Returns the product with the corresponing inputed producIdentifier
         *
         * @param itemIdentifier is the unique number every prouct has
         * //@return the productDTO with the corresponding itemIdentifier
         */
        public ItemDTO  getItem (String itemIdentifier) throws InvalidIdentifierException, ConnectivityException {
            if (!itemIdentifier.equals("")) {
                for (ItemDTO itemDTO : inventory) {
                    if (itemDTO.getItemIdentifier().equals(itemIdentifier))
                        return itemDTO;
                    throw new InvalidIdentifierException("the item Identifier: " + itemIdentifier + " does not exist in the inventory ");

                }
            }
            throw new ConnectivityException("Could not reach database");
        }

        /**
         * Returns the whole inventory
         *
         * @return whole inventory
         */
        public ItemDTO[] getInventory () {
            return inventory;
        }
}
