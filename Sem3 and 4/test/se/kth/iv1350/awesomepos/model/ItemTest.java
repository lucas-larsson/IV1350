package se.kth.iv1350.awesomepos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import se.kth.iv1350.awesomepos.model.Item;
import se.kth.iv1350.awesomepos.model.DTO.ItemDTO;


public class ItemTest {


    private Item item;
    private ItemDTO itemDTO;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        itemDTO = new ItemDTO("123456", 25, "Bananer", 0.25F, 2);
        item = new Item(itemDTO, 2);
    }

    @AfterEach
    void tearDown() {
        printoutBuffer = null;
        System.setOut(originalSysOut);
        itemDTO = null;
        item = null;
    }

    @Test
    public void testIfAllGetters() {
        String printout = item.toString();
        String expectedOutput = "item{" +
                "price=" + item.getPrice() +
                ", itemDescription='" + item.getItemDescription() + '\'' +
                ", VAT=" + item.getVAT() +
                ", soldQuantity=" + item.getSoldQuantity() +
                '}';
        assertTrue(printout.contains(expectedOutput), "item-toString did not print correctly.");
    }

}
