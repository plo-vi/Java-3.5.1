package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldHaveAllMethodsFromSuper() {
        Book book = new Book();
    }

    @Test
    public void shouldUseEquals() {
        Book book1 = new Book(2, "B1", 20, "A1");
        Book book2 = new Book(2, "B1", 200, "A1");
        assertEquals(book1, book2);
    }
}