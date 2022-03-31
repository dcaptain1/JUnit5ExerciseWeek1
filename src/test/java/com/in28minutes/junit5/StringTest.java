package com.in28minutes.junit5;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Gustav Holst , gusho-0@student.ltu.se
 */

public class StringTest {

    private String str;

    @BeforeEach
    void beforeEach(TestInfo info){
                System.out.println("Initialize test data before " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info){
        System.out.println("clean up test data after for " + info.getDisplayName() + "\n");
    }

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
    void length_greater_than_zero() {
        assertTrue("ABCD".length()>0);
        assertTrue("ABC".length()>0);
        assertTrue("A".length()>0);
        assertTrue("DEF".length()>0);
    }


    @ParameterizedTest
    @ValueSource(strings = {"ABCD","p", "ABC","A","DEF"})
    void length_greater_than_zero_using_parameterized_test(String str) {
        assertTrue(str.length()>0);

    }

    @Test
    void uppercase() {
        assertEquals("ABCD","abcd".toUpperCase());
        assertEquals("ABC","abc".toUpperCase());
        assertEquals("","".toUpperCase());
        assertEquals("ABCDEFG","abcdefg".toUpperCase());

    }

    @ParameterizedTest(name = "{0} toUpperCase is {1}")
    @CsvSource(value = {"abcd,ABCD","abc,ABC","'',''","abcdefg,ABCDEFG"})
    void uppercase_parameterized_test(String word, String capitalizedWord) {
        assertEquals(capitalizedWord,word.toUpperCase());
    }

    @ParameterizedTest(name = "{0} length is {1}")
    @CsvSource(value = {"abcd,4","abc,3","'',0","abcdefg,7"})
    void length_parameterized_test(String word, int expectedLength) {
        assertEquals(expectedLength,word.length());
    }

    @Test
    @DisplayName("When length is null, throw an exception")
    void length_exception(){

        String str = null;
        assertThrows(NullPointerException.class,
                () -> {
                    str.length();
                }

                );

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
    @RepeatedTest(10)
    void contains_basic(){
        String str = "abcdefgh";
        Boolean result = str.contains("ijk");

        assertEquals(false,result);
        assertFalse(result);

    }

    @Test
    void split_basic(){
        String str = "abc def ghi";
        String actualResult[] = str.split(" ");
        String[] expectedResult = new String[] {"abc", "def",  "ghi"};

        assertArrayEquals(expectedResult,actualResult);

    }

    @Test
    @Disabled
    void performanceTest() {
        assertTimeout(Duration.ofSeconds(5),

                () -> {
                    for(int i = 0;i<1000000;i++){
                        int j = i;
                        System.out.println(j);
                    }


                }

                );

    }


    @Nested
    class EmptyStringTest{

        @BeforeEach
        void setToEmpty(){
            str = "";
        }

        @Test
        @DisplayName("Length should be zero")
        void lengthIsZero(){
            assertEquals(0,str.length());
        }

        @Test
        @DisplayName("uppercase is empty")
        void uppercaseIsEmpty(){
            assertEquals("",str.toUpperCase());
        }

    }






}





































