package de.lernenJava.doaa.ToDoList2.dataAccessObject;

import de.lernenJava.doaa.ToDoList2.models.Category;
import de.lernenJava.doaa.ToDoList2.models.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CategoryDAOTest {
    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    void whenFindAllThenReturnCategories() {
        // Given
        Category someCategory = new Category();
        someCategory.setCategoryName("Some Category");
        Task task1 = new Task();
        task1.setCategory(someCategory);
        task1.setDateTime(LocalDateTime.of(2020, 1, 25, 14, 0));
        List<Task> tasks = List.of(task1);
        someCategory.setCategoryTasks(tasks);
        entityManager.persist(someCategory);
        entityManager.flush();

        // When
        List<Category> categories = categoryDAO.findAll();

        // Then
        assertThat(categories.size()).isEqualTo(1);
        Category persistedCategory = categories.get(0);
        assertThat(persistedCategory.getCategoryName()).isEqualTo("Some Category");
        assertThat(persistedCategory.getCategoryTasks()).isNotNull().isNotEmpty();
        assertThat(persistedCategory.getCategoryId()).isNotNull().isNotNegative();
    }

    @Test
    void whenFindAllAndNoCategoriesAvailableThenReturnEmptyList() {
        // When
        List<Category> categories = categoryDAO.findAll();

        // Then
        assertThat(categories).isEmpty();
    }
}