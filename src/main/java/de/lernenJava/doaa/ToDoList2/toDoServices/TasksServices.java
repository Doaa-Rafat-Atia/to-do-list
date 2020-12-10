package de.lernenJava.doaa.ToDoList2.toDoServices;

import de.lernenJava.doaa.ToDoList2.DTOs.LocalDateTimeDTO;
import de.lernenJava.doaa.ToDoList2.dataAccessObject.TaskDAO;
import de.lernenJava.doaa.ToDoList2.models.Task;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@AllArgsConstructor
public class TasksServices {
    @Autowired
    private TaskDAO taskDAO;
    public Iterable<Task> findAllTasks()
    {
        return taskDAO.findAll();

    }
public Iterable<Task> getTasksByDate(LocalDateTimeDTO localDateTimeDTO_object)
{return taskDAO.findByDateTime(localDateTimeDTO_object.convertStringToDate()); }
public void deleteTaskById(int id)
{
    taskDAO.deleteById(id);
}
}
