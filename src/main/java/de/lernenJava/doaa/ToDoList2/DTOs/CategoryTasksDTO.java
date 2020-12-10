package de.lernenJava.doaa.ToDoList2.DTOs;

import de.lernenJava.doaa.ToDoList2.models.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class CategoryTasksDTO {
    private String categoryName;
    private Task task;


}
