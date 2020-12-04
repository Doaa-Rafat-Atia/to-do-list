package de.lernenJava.doaa.ToDoList2.api;


import de.lernenJava.doaa.ToDoList2.models.Category;
import de.lernenJava.doaa.ToDoList2.models.CategoryTasksDTO;
import de.lernenJava.doaa.ToDoList2.models.Tasks;
import de.lernenJava.doaa.ToDoList2.toDoServices.CategoryServices;
import de.lernenJava.doaa.ToDoList2.toDoServices.TasksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ToDoListApi {
    @Autowired
    CategoryServices categoryServices;
@Autowired
    TasksServices tasksServices;
    @PostMapping(value="/addCategory")
    public Category addCategory(@RequestBody Category category)
    { return categoryServices.addCategory(category);}

   @PostMapping ("/addTask")
    public void addSingleTaskToCategory(@RequestBody CategoryTasksDTO categoryTasksDTO)
    {categoryServices.addSingleTaskToCategory(categoryTasksDTO.getTask(),categoryTasksDTO.getCategoryName());}
   @GetMapping("/getAllTasks")
    public Iterable<Tasks> findAllTasks()
   {
       return tasksServices.findAllTasks();
   }
    /* @PostMapping("/addMultipleTasks")
    public void addTasksToCategory(@RequestBody CategoryTasksDTO categoryTasksDTO)
    {
        categoryServices.addTasksToCategory(categoryTasksDTO.getTasks(),categoryTasksDTO.getCategoryName());
    }
    @GetMapping("/getCategoryByName")
    public Category getCategoryByName(@RequestParam String categoryName)
    { return categoryServices.getCategory(categoryName);}*/
}