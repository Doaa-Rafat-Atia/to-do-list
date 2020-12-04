package de.lernenJava.doaa.ToDoList2.dataAccessObject;

import de.lernenJava.doaa.ToDoList2.models.Tasks;
import de.lernenJava.doaa.ToDoList2.toDoServices.TasksServices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDAO extends CrudRepository<Tasks,Integer> {
    @Override
    List<Tasks> findAll();
}