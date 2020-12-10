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
public class CategoryService {
    @Autowired
    private  CategoryDAO categoryDAO;
    @Autowired
    private TaskDAO taskDAO;

    private List<Category>categoryList= new CopyOnWriteArrayList<>();

    public CategoryService(CategoryDAO categoryDAO, TaskDAO taskDAO) {
        this.categoryDAO = categoryDAO;
        this.taskDAO = taskDAO;
    }

    public Category addCategory(Category category) {
        categoryList.add(category);
       taskDAO.saveAll(category.getCategoryTasks());

        return categoryDAO.save(category);
    }
    public List<Category> getCategories()
    {
        //return categoryList;
        return categoryDAO.findAll();
    }
    public void addSingleTaskToCategory(Task task, String categoryName)
    {

   categoryList.stream().
            forEach(category ->
    {if (category.getCatName().equals(categoryName))
    {
        task.setCategory(category);

        taskDAO.save(task);
   categoryDAO.save(category);
    }});

   }

    public Category getCategoryByName(String categoryName)
    {
        return categoryList.stream()
                .filter(category -> category.getCatName().equals(categoryName))
                .findAny()
                .get();
    }
   public Category updateCategory(Category newCategory,String currentCategoryName ) throws CategoryNotFoundException {
       for(Category category : categoryList) {
           if(category.getCatName().equals(currentCategoryName))
           {
               category.setCatName(newCategory.getCatName());
               for(Task t: newCategory.getCategoryTasks()) {
                   t.setCategory(category);

               }
               category.setCategoryTasks(newCategory.getCategoryTasks());

               categoryDAO.save(category);

               return category;
           }
       }
       throw new CategoryNotFoundException();
   }

}
