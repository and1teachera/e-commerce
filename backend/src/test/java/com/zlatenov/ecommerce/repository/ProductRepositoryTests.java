package com.zlatenov.ecommerce.repository;

import com.zlatenov.ecommerce.entity.Product;
import com.zlatenov.ecommerce.entity.ProductCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    @DisplayName("Should find all products")
    public void shouldFindAll() {
        assertThat(productRepository).isNotNull();
        Product product = new Product();
        product.setName("Test Product");
        product.setActive(true);
        product.setUnitsInStock(10);
        product.setDescription("Test Description");
        product.setImageUrl("Test Image URL");
        product.setSku("Test SKU");
        product.setUnitPrice(new BigDecimal("19.99"));
        ProductCategory category = new ProductCategory();
        category.setCategoryName("Test Category");
        productCategoryRepository.save(category);
        product.setCategory(category);
        productRepository.save(product);

        assertThat(productRepository.findAll()).isNotEmpty();
    }

    @Test
    @DisplayName("Should find product by ID")
    public void shouldFindById() {
        Product product = new Product();
        product.setName("Test Product");
        product.setActive(true);
        product.setUnitsInStock(10);
        product.setDescription("Test Description");
        product.setImageUrl("Test Image URL");
        product.setSku("Test SKU");
        product.setUnitPrice(new BigDecimal("19.99"));
        ProductCategory category = new ProductCategory();
        category.setCategoryName("Test Category");
        productCategoryRepository.save(category);
        product.setCategory(category);
        productRepository.save(product);

        Optional<Product> foundProduct = productRepository.findById(product.getId());
        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getName()).isEqualTo("Test Product");
    }

    @Test
    @DisplayName("Should save a new product")
    public void shouldSave() {
        Product product = new Product();
        product.setName("New Product");
        product.setActive(true);
        product.setUnitsInStock(20);
        product.setDescription("New Description");
        product.setImageUrl("New Image URL");
        product.setSku("New SKU");
        product.setUnitPrice(new BigDecimal("29.99"));
        ProductCategory category = new ProductCategory();
        category.setCategoryName("New Category");
        productCategoryRepository.save(category);
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isNotNull();
    }

    @Test
    @DisplayName("Should delete a product")
    public void shouldDelete() {
        Product product = new Product();
        product.setName("Delete Product");
        product.setActive(true);
        product.setUnitsInStock(5);
        product.setDescription("Delete Description");
        product.setImageUrl("Delete Image URL");
        product.setSku("Delete SKU");
        product.setUnitPrice(new BigDecimal("9.99"));
        ProductCategory category = new ProductCategory();
        category.setCategoryName("Delete Category");
        productCategoryRepository.save(category);
        product.setCategory(category);
        productRepository.save(product);

        productRepository.delete(product);
        Optional<Product> deletedProduct = productRepository.findById(product.getId());
        assertThat(deletedProduct).isNotPresent();
    }
}