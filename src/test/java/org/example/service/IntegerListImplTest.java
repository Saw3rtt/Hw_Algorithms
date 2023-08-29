package org.example.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private IntegerListImpl sut;

    @BeforeEach
    private void initSut() {
        sut = new IntegerListImpl(
                new Integer[]{15, 16, 17, 18, 19}
        );
    }

    @Test
    void add_shouldReturnAddedInteger() {
        var actual = sut.add(154);
        assertEquals(154, actual);
        assertArrayEquals(new Integer[]{15, 16, 17, 18, 19, 154}, sut.toArray());
    }

    @Test
    void add_shouldThrowNullPointerExceptionIfNullPassed() {
        assertThrows(NullPointerException.class, () -> sut.add(null));
    }

    @Test
    void add_shouldReturnAddedIntegerInsertedIntoIndexEqualToSize() {
        var actual = sut.add(5, 123);
        assertEquals(123, actual);
        assertArrayEquals(new Integer[]{15, 16, 17, 18, 19, 123}, sut.toArray());
    }

    @Test
    void add_shouldThrowIndexOutOfBoundsExceptionIfIndexBiggerThanSizeOrLessThanZero() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.add(7, 13));
        assertThrows(IndexOutOfBoundsException.class, () -> sut.add(-1, 13));
    }

    @Test
    void set_shouldReturnInsertedIntegerSetIntoProvidedIndex() {
        var actual = sut.set(0, 12);
        assertEquals(12, actual);
        assertArrayEquals(new Integer[]{12, 16, 17, 18, 19}, sut.toArray());
    }

    @Test
    void set_shouldThrowOutOfBoundsExceptionIfIndexProvidedIsHigherThanLengthOfTheArray() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.set(-1, 12));
        assertThrows(IndexOutOfBoundsException.class, () -> sut.set(6, 12));
    }

    @Test
    void remove_shouldThrowNoSuchElementExceptionIfElementNotFound() {
        assertThrows(NoSuchElementException.class, () -> sut.remove(-1));
    }

    @Test
    void contains_shouldReturnTrueIfElementIsPresent() {
        assertTrue(sut.contains(15));
    }

    @Test
    void contains_shouldReturnFalseIfElementIsAbsent() {
        assertFalse(sut.contains(151));
    }

    @Test
    void indexOf_shouldReturnIndexOfFirstFoundElement() {
        var actual = sut.indexOf(19);
        assertEquals(4, actual);
    }

    @Test
    void indexOf_shouldReturnMinusOneIfElementNotFound() {
        var actual = sut.indexOf(-8);
        assertEquals(-1, actual);
    }

    @Test
    void lastIndexOf_shouldReturnIndexOfLastFoundElement() {
        sut.add(35);
        var actual = sut.lastIndexOf(16);
        assertEquals(1, actual);
    }

    @Test
    void lastIndexOf_shouldReturnMinusOneIfElementNotFound() {
        var actual = sut.indexOf(341234);
        assertEquals(-1, actual);
    }

    @Test
    void get_shouldReturnElementOfProvidedIndex() {
        var actual = sut.get(2);
        assertEquals(17, actual);
    }

    @Test
    void get_shouldThrowOutOfBoundsExceptionIfIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> sut.get(6));
    }

    @Test
    void equals_shouldReturnTrueIfListsAreEqual() {
        var check = new IntegerListImpl(new Integer[]{15, 16, 17, 18, 19});
        var check2 = sut;
        assertTrue(sut.equals(check));
        assertTrue(sut.equals(check2));
    }

    @Test
    void equals_shouldReturnFalseIfListsAreNotEqual() {
        var check = new IntegerListImpl(new Integer[]{15, 16, 17, 18, 19,20});
        assertFalse(sut.equals(check));
    }

    @Test
    void equals_shouldThrowNullExceptionIfNullProvided() {
        assertThrows(NullPointerException.class, () -> sut.equals(null));
    }

    @Test
    void size_shouldReturnArrayLength() {
        assertEquals(5, sut.size());
    }

    @Test
    void isEmpty_shouldReturnFalseIfThereAreElements() {
        assertFalse(sut.isEmpty());
    }

    @Test
    void isEmpty_shouldReturnTrueIfThereAreNoElements() {
        assertTrue(new service.StringListImpl().isEmpty());
    }

    @Test
    void clear_shouldClearArray() {
        sut.clear();
        assertTrue(sut.isEmpty());
    }

    @Test
    void toArray_shouldReturnArray() {
        var actual = sut.toArray();
        assertArrayEquals(actual, new Integer[]{15, 16, 17, 18, 19});
    }
}