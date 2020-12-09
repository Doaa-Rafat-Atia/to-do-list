package de.lernenJava.doaa.ToDoList2.api;


import de.lernenJava.doaa.ToDoList2.exceptions.CategoryNotFoundException;
import de.lernenJava.doaa.ToDoList2.models.Category;
import de.lernenJava.doaa.ToDoList2.models.CategoryTasksDTO;
import de.lernenJava.doaa.ToDoList2.models.Task;
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
    public Iterable<Task> findAllTasks()
   {
       return tasksServices.findAllTasks();
   }
   @GetMapping("/getAllCategories")
   public Iterable<Category> getAllCategories()
   {
      return  categoryServices.getAllCategories();
   }
    @GetMapping("/getCategoryByName")
    public Category getCategoryByName(@RequestParam String categoryName)
    { return categoryServices.getCategoryByName(categoryName);}
@PutMapping("/updateCategory/{categoryName}")
public void updateCategory(@PathVariable("categoryName") String categoryName, @RequestBody Category category)
{
    try {
         categoryServices.updateCategory(category,categoryName);
    } catch (CategoryNotFoundException e) {
        e.printStackTrace();
    }

}
    /* @PostMapping("/addMultipleTasks")
    public void addTasksToCategory(@RequestBody CategoryTasksDTO categoryTasksDTO)
    {
        categoryServices.addTasksToCategory(categoryTasksDTO.getTasks(),categoryTasksDTO.getCategoryName());
    }
   */
}
