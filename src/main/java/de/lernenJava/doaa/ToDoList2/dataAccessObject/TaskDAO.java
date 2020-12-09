package de.lernenJava.doaa.ToDoList2.dataAccessObject;

import de.lernenJava.doaa.ToDoList2.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDAO extends CrudRepository<Task,Integer> {
    @Override
    List<Task> findAll();
}