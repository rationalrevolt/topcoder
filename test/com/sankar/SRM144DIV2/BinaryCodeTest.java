package com.sankar.SRM144DIV2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryCodeTest {
    
    private BinaryCode binaryCode = new BinaryCode();
    
    @Test public void
    test_case_0() {
        testEqual(new String[]{ "011100011",  "NONE" }, binaryCode.decode("123210122"));
    }
    
    @Test public void
    test_case_1() {
        testEqual(new String[]{ "01",  "10" }, binaryCode.decode("11"));
    }
    
    @Test public void
    test_case_2() {
        testEqual(new String[]{ "NONE",  "11001" }, binaryCode.decode("22111"));
    }
    
    @Test public void
    test_case_3() {
        testEqual(new String[]{ "NONE",  "NONE" }, binaryCode.decode("123210120"));
    }
    
    @Test public void
    test_case_4() {
        testEqual(new String[]{ "NONE",  "NONE" }, binaryCode.decode("3"));
    }
    
    @Test public void
    test_case_5() {
        testEqual(new String[]{ "01101001101101001101001001001101001", "10110010110110010110010010010110010" }, binaryCode.decode("12221112222221112221111111112221111"));
    }
    
    private void testEqual(String[] expected, String[] solution) {
        for(int i = 0; i < expected.length; i++)
            assertEquals(expected[i], solution[i]);
    }

}
