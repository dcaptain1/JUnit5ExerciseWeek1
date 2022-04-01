package com.in28minutes.junit5;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Gustav Holst , gushol-0@student.ltu.se
 */

public class StringTest {
    private String str;


    @BeforeEach
    @DisplayName("Before each: ")
    void beforeEach(TestInfo info){
                System.out.println("Initialize test data before " + info.getDisplayName());
    }

    @AfterEach
    @DisplayName("After each: ")
    void afterEach(TestInfo info){
        System.out.println("clean up test data after for " + info.getDisplayName() + "\n");
    }

    @Test
    @DisplayName("Testing length of string")
    void length_basic(){
        //Write test code here :)
        //Invoke method
        //Make checks to see if its actually working

        int actualLength = "ABCD".length();
        int expectedLength = 4;

        assertEquals(expectedLength,actualLength);


    }

    @Test
    @DisplayName("Test for String greater than zero")
    void length_greater_than_zero() {
        assertTrue("ABCD".length()>0);
        assertTrue("ABC".length()>0);
        assertTrue("A".length()>0);
        assertTrue("DEF".length()>0);
    }


    @ParameterizedTest
    @DisplayName("Parameterized test for string greater than zero")
    @ValueSource(strings = {"ABCD","p", "ABC","A","DEF"})
    void length_greater_than_zero_using_parameterized_test(String str) {
        assertTrue(str.length()>0);

    }

    @Test
    @DisplayName("Uppercase test")
    void uppercase() {
        assertEquals("ABCD","abcd".toUpperCase());
        assertEquals("ABC","abc".toUpperCase());
        assertEquals("","".toUpperCase());
        assertEquals("ABCDEFG","abcdefg".toUpperCase());

    }

    @ParameterizedTest(name = "{0} toUpperCase is {1}")
    @DisplayName("Parameterized test for uppercase")
    @CsvSource(value = {"abcd,ABCD","abc,ABC","'',''","abcdefg,ABCDEFG"})
    void uppercase_parameterized_test(String word, String capitalizedWord) {
        assertEquals(capitalizedWord,word.toUpperCase());
    }

    @ParameterizedTest(name = "{0} length is {1}")
    @DisplayName("Parameterized String length test")
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
    @DisplayName("toUppercase test")
    void toUpperCase(){

        String str = "abcd";
        String result = str.toUpperCase();


        assertNotNull(result);
        //assertNull(result);
        assertEquals("ABCD", result);


    }

    @Test
    @DisplayName("contains test 10 times")
    @RepeatedTest(10)
    void contains_basic(){
        String str = "abcdefgh";
        Boolean result = str.contains("ijk");

        assertEquals(false,result);
        assertFalse(result);

    }

    @Test
    @DisplayName("split string test")
    void split_basic(){
        String str = "abc def ghi";
        String actualResult[] = str.split(" ");
        String[] expectedResult = new String[] {"abc", "def",  "ghi"};

        assertArrayEquals(expectedResult,actualResult);

    }

    @Test
    @DisplayName("Performance test")
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
    @DisplayName("EmptyString test nested")
    class EmptyStringTest{

        @BeforeEach
        @DisplayName("Emptying string before each")
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





































