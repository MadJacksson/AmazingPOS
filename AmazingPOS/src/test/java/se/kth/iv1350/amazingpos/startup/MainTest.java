package se.kth.iv1350.amazingpos.startup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.controller.SearchFailedException;
import se.kth.iv1350.amazingpos.integration.AddItemException;
import se.kth.iv1350.amazingpos.integration.NoDatabaseException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private Main instanceToTest;
    private ByteArrayOutputStream printout;
    private PrintStream originalSysOut;
    
    @BeforeEach
    public void setUp() {
        instanceToTest = new Main();
        
        printout = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printout);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        
        printout = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testUIHasStarted() throws IOException, SearchFailedException, NoDatabaseException, AddItemException {
        String[] args = null;
        Main.main(args);
        String printouts = printout.toString();
        String expectedOutput = "started";
        assertTrue(printouts.contains(expectedOutput), "UI did not start correctly.");
    }    
}
