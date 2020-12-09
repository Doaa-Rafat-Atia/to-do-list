package de.lernenJava.doaa.ToDoList2.toDoServices;

import de.lernenJava.doaa.ToDoList2.dataAccessObject.CategoryDAO;
import de.lernenJava.doaa.ToDoList2.dataAccessObject.TaskDAO;
import de.lernenJava.doaa.ToDoList2.exceptions.CategoryNotFoundException;
import de.lernenJava.doaa.ToDoList2.models.Category;
import de.lernenJava.doaa.ToDoList2.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    private Task temp;

    public Category addCategory(Category category) {
       /* category.setCategoryId(categoryCount);
        categoryList.add(category);
        categoryCount++;
        return category;*/
        categoryList.add(category);
        taskDAO.saveAll(category.getCategoryTasks());
        return categoryDAO.save(category);
    }
    public List<Category> getAllCategories()
    {
        //return categoryList;
        return categoryDAO.findAll();
    }
    public void addSingleTaskToCategory(Task task, String categoryName)
    {

   categoryList.stream().forEach(category ->
    {if (category.getCategoryName().equals(categoryName))
    {
        task.setCategory(category);
//        category.addTask(task);
        taskDAO.save(task);
   categoryDAO.save(category);
    }});

   }

    public Category getCategoryByName(String categoryName)
    {
        return categoryList.stream()
                .filter(category -> category.getCategoryName().equals(categoryName))
                .findAny()
                .get();
    }
   public Category updateCategory(Category newCategory,String currentCategoryName ) throws CategoryNotFoundException {
       for(Category category : categoryList) {
           if(category.getCategoryName().equals(currentCategoryName))
           {
               category.setCategoryName(newCategory.getCategoryName());
               category.setCategoryTasks(newCategory.getCategoryTasks());

               categoryDAO.save(category);
               taskDAO.saveAll(category.getCategoryTasks());
               return category;
           }
       }
       throw new CategoryNotFoundException();
   }

       /*categoryList.stream()
               .filter(category -> category.getCategoryName().equals(categoryName))
               .map(category -> {
                   category.setCategoryName(newCategory.getCategoryName());
                   category.setCategoryTasks(newCategory.getCategoryTasks());
                   return categoryDAO.save(category);
               }).findAny().get();

   }*/
}
