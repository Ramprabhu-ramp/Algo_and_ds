package org.assignment;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuicksortTest {

    //Modified high index values from originally provided test cases

    @Test
    public void test_empty_array() {
        App classUnderTest = new App();

        int[] arr = {};
        int[] expected = {};
        classUnderTest.QuickSort(arr, 0, -1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void test_single_element_array() {
        App classUnderTest = new App();

        int[] arr = { 1 };
        int[] expected = { 1 };
        classUnderTest.QuickSort(arr, 0, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void test_sorted_array() {
        App classUnderTest = new App();

        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        classUnderTest.QuickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void test_reverse_sorted_array() {
        App classUnderTest = new App();

        int[] arr = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        classUnderTest.QuickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void test_array_with_duplicates() {
        App classUnderTest = new App();

        int[] arr = { 3, 1, 4, 2, 2, 5, 5 };
        int[] expected = { 1, 2, 2, 3, 4, 5, 5 };
        classUnderTest.QuickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void test_single_out_of_order_element() {
        App classUnderTest = new App();

        int[] arr = { 1, 6, 3, 4, 5, 7, 8, 9 };
        int[] expected = { 1, 3, 4, 5, 6, 7, 8, 9 };
        classUnderTest.QuickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void test_array_with_identical_elements() {
        App classUnderTest = new App();

        int[] arr = { 2, 2, 2, 2, 2, 2, 2, 1 };
        int[] expected = { 1, 2, 2, 2, 2, 2, 2, 2 };
        classUnderTest.QuickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }
}
