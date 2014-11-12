package com.sankar.SRM144DIV2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeTest {
    
    private Time time = new Time();
    
    @Test public void
    test_case_0() {
        assertEquals("0:0:0", time.whatTime(0));
    }
    
    @Test public void
    test_case_1() {
        assertEquals("1:1:1", time.whatTime(3661));
    }
    
    @Test public void
    test_case_2() {
        assertEquals("1:30:36", time.whatTime(5436));
    }
    
    @Test public void
    test_case_3() {
        assertEquals("23:59:59", time.whatTime(86399));
    }

}
