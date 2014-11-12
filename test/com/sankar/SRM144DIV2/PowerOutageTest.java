package com.sankar.SRM144DIV2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerOutageTest {
    
    private int[] from;
    private int[] to;
    private int[] times;
    
    private PowerOutage powerOutage = new PowerOutage();
    
    @Test public void
    test_case_0() {
        from = arr(0);
        to = arr(1);
        times = arr(10);
        
        test(10);
    }
    
    @Test public void
    test_case_1() {
        from = arr(0,1,0);
        to = arr(1,2,3);
        times = arr(10,10,10);
        
        test(40);
    }
    
    @Test public void
    test_case_2() {
        from = arr(0,0,0,1,4);
        to = arr(1,3,4,2,5);
        times = arr(10,10,100,10,5);
        
        test(165);
    }
    
    @Test public void
    test_case_3() {
        from = arr(0,0,0,1,4,4,6,7,7,7,20);
        to = arr(1,3,4,2,5,6,7,20,9,10,31);
        times = arr(10,10,100,10,5,1,1,100,1,1,5);
        
        test(281);
    }
    
    @Test public void
    test_case_4() {
        from = arr(0,0,0,0,0);
        to = arr(1,2,3,4,5);
        times = arr(100,200,300,400,500);
        
        test(2500);
    }
    
    private void test(int result) {
        assertEquals(result, powerOutage.estimateTimeOut(from, to, times));
    }
    
    private int[] arr(int... values) {
        return values;
    }

}
