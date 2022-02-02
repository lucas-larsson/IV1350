package se.kth.iv1350.awesomepos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import se.kth.iv1350.awesomepos.Integration.ConnectivityException;
import se.kth.iv1350.awesomepos.Integration.InvalidIdentifierException;
import se.kth.iv1350.awesomepos.model.DTO.ItemDTO;
import se.kth.iv1350.awesomepos.Integration.ExternalInventorySystem;
public class ExternalInventorySystemTest {

    private ExternalInventorySystem instanceToTest;
    private ItemDTO[] inventory;

    @BeforeEach
    public void setUp() {
        instanceToTest = new ExternalInventorySystem();
//        inventory = InventorySystem.getInventory();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCheckIfItemInInventory() throws InvalidIdentifierException, ConnectivityException {
        ItemDTO expectedItem = new ItemDTO("123456", 69, "MacBook Pro Ultra Max", 0.25F, 0);
        ItemDTO result = null;
        String identifier = "123456";
        try {
            result = instanceToTest.getItem(identifier);
            assertTrue(result.getItemDescription().contains("MacBook Pro Ultra Max"));
        } catch (InvalidIdentifierException e) {
            assertTrue(e.getMessage().contains("No item with identifier:"), "InvalidIdentifierException was thrown");
        } catch (ConnectivityException e) {
            assertTrue(e.getMessage().contains("Could not reach the database"), "ConnectivityException was thrown");
        }
    }

    @Test
    public void testCheckIfItemInInventoryException() throws InvalidIdentifierException, ConnectivityException {
        ItemDTO result = null;
        String identifier = "9999999999";
        try {
            result = instanceToTest.getItem(identifier);
            fail("Item that should not be found was found");
//            fail("Item not found");
        } catch (InvalidIdentifierException e) {
            assertTrue(e.getMessage().contains("No item with identifier: "), "InvalidIdentifierException not thrown");
        }
    }

    @Test
    public void testCheckIfInventorySystemIsNotConnectedException() throws InvalidIdentifierException, ConnectivityException {
        ItemDTO result = null;
        String identifier = "";
        try {
            result = instanceToTest.getItem(identifier);
            fail("Exception was not thrown");
        } catch (ConnectivityException e) {
            assertTrue(e.getMessage().contains("Could not reach the database"), "ConnectivityException not thrown");
        }
    }
}
