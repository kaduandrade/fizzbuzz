package com.fizzbuzz.test;

import com.fizzbuzz.business.FizzBuzz;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest extends FizzBuzz {

    @Test
    public void testMultipleOfThreeAndFive() {
        assertEquals(FIZZBUZZ, checkFizzBuzz(15, 1));
    }

    @Test
    public void testMultipleOfThree() {
        assertEquals(FIZZ, checkFizzBuzz(9, 1)); }

    @Test
    public void testMultipleOfFive() {
        assertEquals(BUZZ, checkFizzBuzz(20, 1)); }

    @Test
    public void testNonMulitpleOfThreeOrFive() {
        assertEquals("7", checkFizzBuzz(7, 1));
    }

}