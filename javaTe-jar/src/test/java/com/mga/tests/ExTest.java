package com.mga.tests;

import com.mga.exs.Ex;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class ExTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *         name of the test case
     */
    public ExTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ExTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testSayHello() {
        Ex ex = new Ex();
        // TOFO : some Assert 
    }
}
