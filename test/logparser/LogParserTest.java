/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logparser;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Guanhoe
 */
public class LogParserTest {
    
    public LogParserTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of readFile method, of class LogParser.
     */
    @Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        String filepath = "";
        LogParser instance = new LogParser();
        instance.readFile(filepath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countIPVisits method, of class LogParser.
     */
    @Test
    public void testCountIPVisits() {
        System.out.println("countIPVisits");
        LogParser instance = new LogParser();
        HashMap<String, Integer> expResult = null;
        HashMap<String, Integer> result = instance.countIPVisits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countURLVisits method, of class LogParser.
     */
    @Test
    public void testCountURLVisits() {
        System.out.println("countURLVisits");
        LogParser instance = new LogParser();
        HashMap<String, Integer> expResult = null;
        HashMap<String, Integer> result = instance.countURLVisits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByValue method, of class LogParser.
     */
    @Test
    public void testSortByValue() {
        System.out.println("sortByValue");
        HashMap<String, Integer> map = null;
        HashMap<String, Integer> expResult = null;
        HashMap<String, Integer> result = LogParser.sortByValue(map);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTop3 method, of class LogParser.
     */
    @Test
    public void testGetTop3() {
        System.out.println("getTop3");
        HashMap<String, Integer> map = null;
        List<String> expResult = null;
        List<String> result = LogParser.getTop3(map);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class LogParser.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        LogParser.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
