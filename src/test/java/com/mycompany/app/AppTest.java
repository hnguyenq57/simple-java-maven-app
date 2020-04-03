package com.mycompany.app;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import org.testng.annotations.BeforeClass;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @BeforeClass
	public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAppConstructor() {
        try {
            new App();
        } catch (Exception e) {
            Assert.fail("Construction failed.");
        }
    }

    @Test
    public void testAppMain()
    {
      
    	App.main(null);       
        try {
            AssertJUnit.assertEquals("Hello World3!" + System.getProperty("line.separator"), outContent.toString());
        } catch (AssertionError e) {
            Assert.fail("\"message\" is not \"Hello World3!\"");
        }
    }

    @AfterClass
	public void cleanUpStreams() {
        //System.setOut(null);
    }

}
