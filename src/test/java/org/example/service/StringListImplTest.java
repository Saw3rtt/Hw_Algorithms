package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


    class StringListImplTest {
        private service.StringListImpl sut;

        @BeforeEach
        private void initSut() {
            sut = new service.StringListImpl(new String[]{"key", "one", "two", "six"});
        }

        @Test
        void add_shouldReturnAddedString() {
            var actual = sut.add("easy");
            assertEquals("easy", actual);
            assertArrayEquals(sut.toArray(), new String[]{"key", "one", "two", "six","easy"});
        }

        @Test
        void add_shouldThrowNullPointerExceptionIfNullPassed() {
            assertThrows(NullPointerException.class, () -> sut.add(null));
        }

        @Test
        void add_shouldReturnAddedStringInsertedIntoProvidedIndex() {
            var actual = sut.add(1, "hard");
            assertEquals("hard", actual);
            assertArrayEquals(sut.toArray(), new String[]{"key","hard", "one", "two", "six"});
        }

        @Test
        void add_shouldReturnAddedStringInsertedIntoIndexEqualToArrayLength() {
            var actual = sut.add(4, "yes");
            assertEquals("yes", actual);
            assertArrayEquals(sut.toArray(), new String[]{"key", "one", "two", "six","yes"});
        }

        @Test
        void add_shouldThrowOutOfBoundsExceptionIfIndexProvidedIsHigherThanLengthOfTheArray() {
            assertThrows(IndexOutOfBoundsException.class, () -> sut.add(-1, "seven"));
            assertThrows(IndexOutOfBoundsException.class, () -> sut.add(5, "seven"));
        }

        @Test
        void set_shouldReturnAddedStringSetIntoProvidedIndex() {
            var actual = sut.set(0, "lock");
            assertEquals("lock", actual);
            assertArrayEquals(sut.toArray(), new String[]{"lock", "one", "two", "six"});
        }

        @Test
        void set_shouldThrowOutOfBoundsExceptionIfIndexProvidedIsHigherThanLengthOfTheArray() {
            assertThrows(IndexOutOfBoundsException.class, () -> sut.set(-1, "nine"));
            assertThrows(IndexOutOfBoundsException.class, () -> sut.set(4, "nine"));
        }

        @Test
        void remove_shouldRemoveStringFromArrayAndReturnDeletedElement() {
            var actual = sut.remove("six");
            assertEquals("six", actual);
            assertArrayEquals(sut.toArray(), new String[]{"key", "one", "two"});
        }

        @Test
        void remove_shouldRemoveElementWithProvidedIndexFromArrayAndReturnDeletedElement() {
            var actual = sut.remove(1);
            assertEquals("one", actual);
            assertArrayEquals(sut.toArray(), new String[]{"key", "two", "six"});

        }

        @Test
        void remove_shouldThrowOutOfBoundExceptionIndexProvidedIsHigherThanLengthOfTheArray() {
            assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(-1));
            assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(4));
        }

        @Test
        void remove_shouldThrowNoSuchElementExceptionIfElementNotFound() {
            assertThrows(NoSuchElementException.class, () -> sut.remove("lock"));
        }

        @Test
        void contains_shouldReturnTrueIfElementIsPresent() {
            assertTrue(sut.contains("one"));
        }

        @Test
        void contains_shouldReturnFalseIfElementIsAbsent() {
            assertFalse(sut.contains("lock"));
        }

        @Test
        void indexOf_shouldReturnIndexOfFirstFoundElement() {
            var actual = sut.indexOf("one");
            assertEquals(1, actual);
        }

        @Test
        void indexOf_shouldReturnMinusOneIfElementNotFound() {
            var actual = sut.indexOf("seven");
            assertEquals(-1, actual);
        }

        @Test
        void lastIndexOf_shouldReturnIndexOfLastFoundElement() {
            var actual = sut.lastIndexOf("six");
            assertEquals(3, actual);
        }

        @Test
        void lastIndexOf_shouldReturnMinusOneIfElementNotFound() {
            var actual = sut.indexOf("four");
            assertEquals(-1, actual);
        }

        @Test
        void get_shouldReturnElementOfProvidedIndex() {
            var actual = sut.get(2);
            assertEquals("two", actual);
        }

        @Test
        void get_shouldThrowOutOfBoundsExceptionIfIndexOutOfBounds() {
            assertThrows(IndexOutOfBoundsException.class, () -> sut.get(-1));
            assertThrows(IndexOutOfBoundsException.class, () -> sut.get(4));
        }

        @Test
        void equals_shouldReturnTrueIfListsAreEqual() {
            var check = new service.StringListImpl(new String[]{"key", "one", "two", "six"});
            var check2 = sut;
            assertTrue(sut.equals(check));
            assertTrue(sut.equals(check2));
        }

        @Test
        void equals_shouldReturnFalseIfListsAreNotEqual() {
            var check = new service.StringListImpl(new String[]{"key", "one", "two"});
            assertFalse(sut.equals(check));
        }

        @Test
        void equals_shouldThrowNullExceptionIfNullProvided() {
            assertThrows(NullPointerException.class, () -> sut.equals(null));
        }

        @Test
        void size_shouldReturnArrayLength() {
            assertEquals(4, sut.size());
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
            assertArrayEquals(actual, new String[]{"key", "one", "two", "six"});
        }
    }

