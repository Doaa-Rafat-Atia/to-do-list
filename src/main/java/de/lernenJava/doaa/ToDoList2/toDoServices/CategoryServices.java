package de.lernenJava.doaa.ToDoList2.toDoServices;
//[REVIEW] please rename the package from toDoServices to services.
// You can add todo as a parent package if you with.

import de.lernenJava.doaa.ToDoList2.dataAccessObject.CategoryDAO;
import de.lernenJava.doaa.ToDoList2.dataAccessObject.TaskDAO;
import de.lernenJava.doaa.ToDoList2.models.Category;
import de.lernenJava.doaa.ToDoList2.models.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class CategoryServices { //[REVIEW] please use singular form (CategoryService)
    @Autowired
    CategoryDAO categoryDAO;    //[REVIEW] Please make this private
    @Autowired
    TaskDAO taskDAO;    //[REVIEW] private

    private List<Category> categoryList = new CopyOnWriteArrayList<>(); //[REVIEW] Why do you use
    // CopyOnWriteArrayList here? As far as I can tell, a simple ArrayList should suffice.
    private int categoryCount = 1; //[REVIEW] this field is never used. Please delete it.
    private Tasks temp; //[REVIEW] this field is never used. Please delete it.

    public Category addCategory(Category category) {
       /* category.setCategoryId(categoryCount);
        categoryList.add(category);
        categoryCount++;
        return category;*/
        categoryList.add(category);
        return categoryDAO.save(category);
    }

    public List<Category> getAllCategories() {
        //return categoryList;
        return categoryDAO.findAll();
    }

    public void addSingleTaskToCategory(Tasks task, String categoryName) {

        categoryList.stream().forEach(category ->
        {
            if (category.getCategoryName().equals(categoryName)) {
                task.setCategory(category);
                //        category.addTask(task);
                taskDAO.save(task);
                //    categoryDAO.save(category);
            }
        });

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
