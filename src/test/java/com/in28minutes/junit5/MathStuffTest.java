package com.in28minutes.junit5;

import com.in28minutes.junit.helper.MathStuff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathStuffTest {

    @Test
    void addThreeNumbers() {
        MathStuff mathStuff = new MathStuff();


        assertEquals(5,mathStuff.addThreeNumbers(1,1,3));
    }

    @Test
    void addThreeNumbersFailing() {
        MathStuff mathStuff = new MathStuff();


        assertEquals(5,mathStuff.addThreeNumbers(6,1,3));
    }

}