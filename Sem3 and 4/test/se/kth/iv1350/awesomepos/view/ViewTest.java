package se.kth.iv1350.awesomepos.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.awesomepos.Integration.DataBaseHandler;
import se.kth.iv1350.awesomepos.Integration.InvalidIdentifierException;
import se.kth.iv1350.awesomepos.controller.Controller;
import se.kth.iv1350.awesomepos.controller.OperationException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ViewTest {

    private View instanceToTest;
    private DataBaseHandler dbHandler;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        dbHandler = new DataBaseHandler();
        System.setOut(inMemSysOut);
        Controller ctrl = new Controller(dbHandler);
        instanceToTest = new View(ctrl);
    }

    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
        Controller ctrl = null;
        instanceToTest = null;
    }

    @Test
    public void testRunFakeExecution() throws InvalidIdentifierException, OperationException {
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();
        assertTrue(printout.contains("started"), "UI did not start correctly.");
    }


 }



