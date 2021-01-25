package com.weldbit.algo.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Test Stack function with 100 coverage.
 */
public class StackTest {
    transient Stack<Integer> stackint;

    /**
     * Set initial values that will be use to verify logic.
     */
    public StackTest() {
        stackint = new Stack<Integer>();
        stackint.push(10);
        stackint.push(20);
        stackint.push(30);
        stackint.push(40);
        stackint.push(50);
    }

    @BeforeAll
    public static void setup() {
        System.out.println("@BeforeAll executed");
    }

    /**
     * Test push logic using parameterized values.
     *
     * @param item - parameterized values.
     *
     */
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
        System.out.println("Test pop integer value:" + stackint.getSize());
        while (stackint.getSize() > 0) {
            Integer topval = stackint.getTop();
            Integer popval = stackint.pop();
            Assertions.assertEquals(topval, popval);
        }

        // Test if everything were removed
        Integer popval = stackint.pop();
        Assertions.assertNull(popval);
    }

    @Test
    public void testTop() {
        Integer topval = stackint.getTop();
        Assertions.assertEquals(50, topval);
    }

    @Test
    public void testBottom() {
        Integer bottomval = stackint.getBottom();
        Assertions.assertEquals(10, bottomval);
    }

    @Test
    public void testPosition() {
        stackint.resetRecordPosition();
        Integer position = stackint.getIndexPosition();
        Assertions.assertEquals(0, position);
    }

    @Test
    public void testIteratorPositionValue() {
        Integer position = stackint.getIndexPosition();
        Assertions.assertEquals(-1, position);
        stackint.resetRecordPosition();
        position = stackint.getIndexPosition();
        Assertions.assertEquals(0, position);
        Integer actual = stackint.iteratorValue();
        Assertions.assertEquals(10, actual);
        actual = stackint.iteratorNext();
        Assertions.assertEquals(20, actual);
        actual = stackint.iteratorNext();
        Assertions.assertEquals(30, actual);
        actual = stackint.iteratorNext();
        Assertions.assertEquals(40, actual);
        actual = stackint.iteratorNext();
        Assertions.assertEquals(50, actual);
        actual = stackint.iteratorNext();
        Assertions.assertEquals(null, actual);
    }

}
