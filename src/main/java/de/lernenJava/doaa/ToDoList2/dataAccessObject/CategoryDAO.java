package de.lernenJava.doaa.ToDoList2.dataAccessObject;

import de.lernenJava.doaa.ToDoList2.models.Category;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDAO extends CrudRepository<Category,Integer> {
    @Override
    @NotNull
    List<Category> findAll();
}
