package com.yumao.algorithmdemo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        AlgorithmTest test = new AlgorithmTest();
        test.quickSort(0, 7);
        test.printlnArray();

        int a = test.quickSelect(1, 0, 7);
        System.out.println(a);
    }
}