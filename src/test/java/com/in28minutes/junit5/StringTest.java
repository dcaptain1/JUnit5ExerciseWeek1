package com.in28minutes.junit5;


import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @Test
    void length_basic(){
        //Write test code here :)
        //Invoke method
        //Make checks to see if its actually working

        int actualLength = "ABCD".length();
        int expectedLength = 4;

        assertEquals(expectedLength,actualLength);


    }

    @Test
    void toUpperCase(){

        String str = "abcd";
        String result = str.toUpperCase();


        assertNotNull(result);
        //assertNull(result);
        assertEquals("ABCD", result);


    }

    @Test
    void contains_basic(){
        String str = "abcdefgh";
        Boolean result = str.contains("ijk");

        assertEquals(false,result);
        assertFalse(result);

    }








}
