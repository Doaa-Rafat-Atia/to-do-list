package de.lernenJava.doaa.ToDoList2.api;


import de.lernenJava.doaa.ToDoList2.DTOs.LocalDateTimeDTO;
import de.lernenJava.doaa.ToDoList2.exceptions.CategoryNotFoundException;
import de.lernenJava.doaa.ToDoList2.models.Category;
import de.lernenJava.doaa.ToDoList2.DTOs.CategoryTasksDTO;
import de.lernenJava.doaa.ToDoList2.models.Task;
import de.lernenJava.doaa.ToDoList2.toDoServices.CategoryService;
import de.lernenJava.doaa.ToDoList2.toDoServices.TasksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ToDoListApi {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TasksServices tasksServices;
    @PostMapping(value="/Category")
    public Category addCategory(@RequestBody Category category)
    { return categoryService.addCategory(category);}

    @PostMapping ("/createTask")
    public void addSingleTaskToCategory(@RequestBody CategoryTasksDTO categoryTasksDTO)
    {
        categoryService.addSingleTaskToCategory(categoryTasksDTO.getTask(),categoryTasksDTO.getCategoryName());}

    @GetMapping("/getTasks")
    public Iterable<Task> getAllTasks()
   {
       return tasksServices.findAllTasks();
   }

   @GetMapping("/getCategories")
    public Iterable<Category> getAllCategories()
   {
      return  categoryService.getCategories();
   }

   @GetMapping("/getCategoryByName")
    public Category getCategoryByName(@RequestParam String categoryName)
    { return categoryService.getCategoryByName(categoryName);}

    @PutMapping("/updateCategory/{categoryName}")
    public void updateCategory(@PathVariable("categoryName") String categoryName, @RequestBody Category category)
    {
    try {
         categoryService.updateCategory(category,categoryName);
    } catch (CategoryNotFoundException e) {
        e.printStackTrace();
    }

    }

    @GetMapping("/getTaskByDate")
    public Iterable<Task> getTaskByDate(@RequestBody LocalDateTimeDTO dateTimeDTO)
   {
     return tasksServices.getTasksByDate(dateTimeDTO);
   }

   @PutMapping("/deleteTaskByID/{id}")
    public void deleteTaskById(@PathVariable("id" ) int id)

   {
    tasksServices.deleteTaskById(id);
   }

}
