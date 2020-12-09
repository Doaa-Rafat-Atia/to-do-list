package de.lernenJava.doaa.ToDoList2.toDoServices;

import de.lernenJava.doaa.ToDoList2.dataAccessObject.TaskDAO;
import de.lernenJava.doaa.ToDoList2.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TasksServices {
    @Autowired
    private TaskDAO taskDAO;
    public Iterable<Task> findAllTasks()
    {
        return taskDAO.findAll();

    }

}
