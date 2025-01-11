package com.zlatenov.ecommerce.repository;

import com.zlatenov.ecommerce.entity.ProductCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class ProductCategoryRepositoryTests {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    @DisplayName("Should find all categories")
    public void shouldFindAll() {
        assertThat(productCategoryRepository).isNotNull();
        ProductCategory category = new ProductCategory();
        category.setCategoryName("Test Category");
        productCategoryRepository.save(category);

        assertThat(productCategoryRepository.findAll()).isNotEmpty();
    }

    @Test
    @DisplayName("Should find category by ID")
    public void shouldFindById() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("Test Category");
        productCategoryRepository.save(category);

        Optional<ProductCategory> foundCategory = productCategoryRepository.findById(category.getId());
        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getCategoryName()).isEqualTo("Test Category");
    }

    @Test
    @DisplayName("Should save a new category")
    public void shouldSave() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("New Category");

        ProductCategory savedCategory = productCategoryRepository.save(category);
        assertThat(savedCategory).isNotNull();
        assertThat(savedCategory.getId()).isNotNull();
    }

    @Test
    @DisplayName("Should delete a category")
    public void shouldDelete() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("Delete Category");
        productCategoryRepository.save(category);

        productCategoryRepository.delete(category);
        Optional<ProductCategory> deletedCategory = productCategoryRepository.findById(category.getId());
        assertThat(deletedCategory).isNotPresent();
    }
}