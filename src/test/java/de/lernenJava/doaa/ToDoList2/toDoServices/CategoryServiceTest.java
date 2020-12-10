package de.lernenJava.doaa.ToDoList2.toDoServices;

import de.lernenJava.doaa.ToDoList2.exceptions.CategoryNotFoundException;
import de.lernenJava.doaa.ToDoList2.models.Category;
import de.lernenJava.doaa.ToDoList2.models.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Test
    void updateCategory() throws CategoryNotFoundException {
        List<Task> tasks = List.of(Task.builder().
                description("Sleep")
                .dateTime(LocalDateTime.of(2020, 11, 22, 14, 0))
                .build());
        Category myCategory = Category.builder()
                .catName("My Category")
                .categoryTasks(tasks)
                .build();
        categoryService.updateCategory(myCategory, "My Category");
    }
}