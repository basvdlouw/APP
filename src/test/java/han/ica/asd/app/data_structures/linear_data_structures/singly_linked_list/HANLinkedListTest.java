package han.ica.asd.app.data_structures.linear_data_structures.singly_linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HANLinkedListTest {

    private HANLinkedList<Integer> singlyLinkedList;

    @BeforeEach
    void setUp() {
        singlyLinkedList = new HANLinkedList<>();
    }

    @Test
    void addFirst() {
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(5);

        assertEquals(5, singlyLinkedList.get(0));
        assertEquals(3, singlyLinkedList.get(1));
    }

    @Test
    void removeFirst() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.removeFirst());

        singlyLinkedList.insert(0,3);
        singlyLinkedList.insert(1,5);

        singlyLinkedList.removeFirst();

        assertEquals(5, singlyLinkedList.get(0));
    }

    @Test
    void insert() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.insert(-1, 10));

        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 30);
        singlyLinkedList.insert(2, 20);
        singlyLinkedList.insert(1, 40);

        assertEquals(10, singlyLinkedList.get(0));
        assertEquals(40, singlyLinkedList.get(1));
        assertEquals(30, singlyLinkedList.get(2));
        assertEquals(20, singlyLinkedList.get(3));
    }

    @Test
    void deleteFirstItem() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.delete(0));

        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 20);
        singlyLinkedList.delete(0);
        assertEquals(20, singlyLinkedList.get(0));
    }

    @Test
    void deleteItemInMiddle() {

        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 20);
        singlyLinkedList.insert(2, 30);
        singlyLinkedList.insert(3, 40);
        singlyLinkedList.delete(2);

        assertEquals(40, singlyLinkedList.get(2));
    }

    @Test
    void get() {
        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 20);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.get(2));
        assertEquals(20, singlyLinkedList.get(1));
    }

    @Test
    void size() {
        assertEquals(0, singlyLinkedList.size());
        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 20);
        singlyLinkedList.insert(2, 30);
        assertEquals(3, singlyLinkedList.size());
    }

    @Test
    void toStringTest() {
        assertEquals("[]", singlyLinkedList.toString());
        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 20);
        assertEquals("[10, 20]", singlyLinkedList.toString());
    }

    @Test
    void isEmpty() {
        assertTrue(singlyLinkedList.isEmpty());
        singlyLinkedList.addFirst(1);
        assertFalse(singlyLinkedList.isEmpty());
    }

    @Test
    void add() {
        singlyLinkedList.add(1);
        assertEquals(1, singlyLinkedList.get(0));
        singlyLinkedList.add(2);
        assertEquals(2, singlyLinkedList.get(1));
        singlyLinkedList.addFirst(5);
        assertEquals(5, singlyLinkedList.get(0));
    }
}