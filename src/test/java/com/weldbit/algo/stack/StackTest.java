package com.weldbit.algo.stack;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StackTest {
    Stack<Integer> stackint;

    public StackTest() {
        stackint = new Stack<Integer>();
    }

    @BeforeAll
    public static void setup() {
        System.out.println("@BeforeAll executed");
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 7, 5, Integer.MAX_VALUE })
    @DisplayName("Test stack push.")
    public void testPush(Integer item) {
        stackint.push(item);
        Integer topval = stackint.getTop();
        Assertions.assertEquals(item, topval);
    }

    @Test
    public void testPop() {
        System.out.println("Test pop integer value:" + stackint.size());
        while (stackint.size() > 0) {
            Integer topval = stackint.getTop();
            Integer popval = stackint.pop();
            Assertions.assertEquals(topval, popval);
        }
    }
}
