package manager;

import domain.Book;
import domain.NotFoundException;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "Java1", 10000, "Author1");
    private Book second = new Book(2, "Java2", 1500, "Author2");
    private Smartphone third = new Smartphone(3, "CallPhone1", 10000, "Maker1");
    private Smartphone fourth = new Smartphone(4, "CallPhone2", 10000, "Maker2");
    private Product fifth = new Product(5, "Love", 1);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    public void shouldGetAll() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, fourth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBooksName() {
        Product[] actual = manager.searchBy("Java1");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBooksAuthor() {
        Product[] actual = manager.searchBy("Author2");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphonesName() {
        Product[] actual = manager.searchBy("CallPhone1");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphonesMaker() {
        Product[] actual = manager.searchBy("Maker2");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducts() {
        Product[] actual = manager.searchBy("Love");
        Product[] expected = new Product[]{fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchName() {
        Product[] actual = manager.searchBy("Nothing");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewProduct() {
        Product sixth = new Product(6, "Smartness", 123456);
        manager.add(sixth);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, third, fourth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveById() {
        assertThrows(NotFoundException.class, () -> repository.removeById(20));
    }
}