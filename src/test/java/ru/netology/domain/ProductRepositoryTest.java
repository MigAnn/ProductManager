package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.repository.ProductRepository;

public class ProductRepositoryTest {
    Product books1 = new Books(4322, "Каменный мост", 1800, "Александр Терехов");
    Product books2 = new Books(894, "Крепость", 2500, "Пётр Алешковский");
    Product smartphone1 = new Smartphone(397, "iPhone 13", 180_000, "Apple");
    Product smartphone2 = new Smartphone(295, "iPhone 11", 50_000, "Apple");

    @Test
    public void removeById() {
        ProductRepository repository = new ProductRepository();
        repository.save(books1);
        repository.save(books2);
        repository.save(smartphone1);
        repository.save(smartphone2);

        repository.removeById(397);
        repository.findAll();

        Product[] actual = repository.findAll();
        Product[] expected = {books1, books2, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }
}
