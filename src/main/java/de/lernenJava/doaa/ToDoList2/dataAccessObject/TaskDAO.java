package de.lernenJava.doaa.ToDoList2.dataAccessObject;

import de.lernenJava.doaa.ToDoList2.models.Tasks;   //[REVIEW] please remember to remove unused imports.
// You can Intellij's [Code -> Optimize Imports] to do it automatically.
// You can also configure Intellij to optimize imports on save.
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDAO extends CrudRepository<Tasks, Integer> {    //[REVIEW] missing space :)
    @Override
    List<Tasks> findAll();
}