package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void shouldUseEquals() {
        Product first = new Product(1, "Java 1", 1000);
        Product second = new Product(1, "Java 1", 1000);
        assertEquals(first, second);
    }

}