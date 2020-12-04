package de.lernenJava.doaa.ToDoList2.toDoServices;

import de.lernenJava.doaa.ToDoList2.dataAccessObject.CategoryDAO;
import de.lernenJava.doaa.ToDoList2.dataAccessObject.TaskDAO;
import de.lernenJava.doaa.ToDoList2.models.Category;
import de.lernenJava.doaa.ToDoList2.models.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class CategoryServices {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    TaskDAO taskDAO;

    private List<Category>categoryList= new CopyOnWriteArrayList<>();
    private int categoryCount=1;
    private Tasks temp;

    public Category addCategory(Category category) {
       /* category.setCategoryId(categoryCount);
        categoryList.add(category);
        categoryCount++;
        return category;*/
        categoryList.add(category);
        return categoryDAO.save(category);
    }
    public List<Category> getAllCategories()
    {
        //return categoryList;
        return categoryDAO.findAll();
    }
    public void addSingleTaskToCategory(Tasks task,String categoryName)
    {

   categoryList.stream().forEach(category ->
    {if (category.getCategoryName().equals(categoryName))
    {
        task.setCategory(category);
//        category.addTask(task);
        taskDAO.save(task);
//    categoryDAO.save(category);
    }});

   }
  /*  public void addTasksToCategory(List<Tasks>tasks,String categoryName)
    {
        categoryList.stream()
                .filter(category -> category.getCategoryName().equals(categoryName))
                .findAny()
                .get()
                .setCategoryTasks(tasks);
    }

    public Category getCategory(String categoryName)
    {
        return categoryList.stream()
                .filter(category -> category.getCategoryName().equals(categoryName))
                .findAny()
                .get();
    }
    //*/
}
