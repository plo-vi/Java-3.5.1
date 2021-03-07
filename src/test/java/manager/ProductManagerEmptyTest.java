package manager;

import domain.Book;
import domain.Product;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerEmptyTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book seventh = new Book(7, "Java7", 1030, "Author7");

    @Test
    void shouldGetEmpty() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByInEmpty() {
        Product[] actual = manager.searchBy("Java7");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByInOneItem() {
        manager.add(seventh);
        Product[] actual = manager.searchBy("Java7");
        Product[] expected = new Product[]{seventh};
        assertArrayEquals(expected, actual);
    }
}
