package se.kth.iv1350.amazingpos.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.controller.SearchFailedException;
import se.kth.iv1350.amazingpos.integration.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    
    @BeforeEach
    void setUp() throws IOException {
        Controller contr = new Controller(new BuildSystem(), new BuildInventory(), new Printer());
        instanceToTest = new View(contr);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @AfterEach
    void tearDown() {
        instanceToTest = null;
        
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    void testRunFakeExecution() throws SearchFailedException, AddItemException {
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "started";
        assertTrue(printout.contains(expectedOutput), "UI did not start correctly.");
    }
}
