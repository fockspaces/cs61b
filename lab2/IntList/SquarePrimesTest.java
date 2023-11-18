package IntList;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testAllPrimes() {
        IntList lst = IntList.of(2, 3, 5, 7);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 9 -> 25 -> 49", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testNoPrimes() {
        IntList lst = IntList.of(4, 6, 8, 10);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 6 -> 8 -> 10", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testSinglePrimeNumber() {
        IntList lst = IntList.of(13);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("169", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testPrimesAtStartAndEnd() {
        IntList lst = IntList.of(2, 4, 6, 7);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 4 -> 6 -> 49", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testLongListMixed() {
        IntList lst = IntList.of(10, 9, 5, 7, 4, 2, 3, 1);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("10 -> 9 -> 25 -> 49 -> 4 -> 4 -> 9 -> 1", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testAdjacentPrimes() {
        IntList lst = IntList.of(3, 5, 8, 11);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("9 -> 25 -> 8 -> 121", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testLargePrimeNumber() {
        IntList lst = IntList.of(29);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("841", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testNonPrimeFirstWithPrimeLater() {
        // Create an IntList where the first element is not prime (e.g., 4)
        // but there is at least one prime number later in the list (e.g., 3).
        IntList lst = IntList.of(4, 6, 8, 3, 10);
        boolean changed = IntListExercises.squarePrimes(lst);

        // The expected list should have the prime number (3) squared
        // but the first element (4) and others remain unchanged.
        assertEquals("4 -> 6 -> 8 -> 9 -> 10", lst.toString());

        // The 'changed' flag should be true because a prime number (3) was squared.
        assertTrue(changed);
    }
}
