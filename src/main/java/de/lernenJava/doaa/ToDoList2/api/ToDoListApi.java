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
    //[REVIEW] add empty line between variable declarations and methods

    @PostMapping(value = "/category")    //[REVIEW] Bad form for REST end point.
    // End points shouldn't contain verbs since they rely on the HTTP verbs.
    // Here, the prefix "add" is redundant to the HTTP POST
    public Category addCategory(@RequestBody Category category) {
        //[REVIEW] missing null value handling
        return categoryServices.addCategory(category);
    }

    @PostMapping("/task")
    //[REVIEW] same as above. REST endpoints should represent resources and rely on HTTP verbs to clarify actions.
    public void addSingleTaskToCategory(@RequestBody CategoryTasksDTO categoryTasksDTO) {
        //[REVIEW] missing null value handling
        categoryServices.addSingleTaskToCategory(categoryTasksDTO.getTask(), categoryTasksDTO.getCategoryName());
    }

    @GetMapping("/tasks")   //[REVIEW]  no need for the "all" prefix. It is implied.
    public Iterable<Tasks> findAllTasks() { //[REVIEW] braces should start on the method declaration line
        //[REVIEW]  please change method name.
        // The current name implies performing search but the method doesn't accept any search parameters and it
        // simply return all tasks.
        // I suggest "getAllTasks" as it is simple and matches the endpoint verb and name.
        // The fact that it calls findAllTasks() internally is irrelevant as per the principle of abstraction.
        // Interfaces should express the intent of the class and hide internal mechanisms from external consumers.
        return tasksServices.findAllTasks();
    }

    //[Review] please delete all unused code instead of commenting it.
    // You can always retrieve the old code from git history if needed :)

    /* @PostMapping("/addMultipleTasks")
    public void addTasksToCategory(@RequestBody CategoryTasksDTO categoryTasksDTO)
    {
        categoryServices.addTasksToCategory(categoryTasksDTO.getTasks(),categoryTasksDTO.getCategoryName());
    }
    @GetMapping("/getCategoryByName")
    public Category getCategoryByName(@RequestParam String categoryName)
    { return categoryServices.getCategory(categoryName);}*/
}
