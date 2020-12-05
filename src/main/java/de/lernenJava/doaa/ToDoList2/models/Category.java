package de.lernenJava.doaa.ToDoList2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;   //[REVIEW] remove unused imports

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId; //[REVIEW] please remove the prefix "category" from all attribute names.
    // It is made redundant by the class name;
    private String categoryName;
    @OneToMany(mappedBy = "category")   //[REVIEW] I prefer to have a blank line before annotated attributes
    @JsonIgnoreProperties("category")
    private List<Tasks> categoryTasks;
    // private Tasks task;  //[REVIEW] always delete unused code

    //[REVIEW] please replace all these setters and getters with Lombok
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Tasks> getCategoryTasks() {
        return categoryTasks;
    }

    public void setCategoryTasks(List<Tasks> categoryTasks) {
        this.categoryTasks = categoryTasks;
    }

    public void addTask(Tasks task) {   //[REVIEW] this method is not used anywhere. Please delete it.
        if (categoryTasks == null) {
            categoryTasks = new CopyOnWriteArrayList<>();
            categoryTasks.add(task);    //[REVIEW] you can remove this line from the if and else and add it after the if
        } else
            categoryTasks.add(task);
    }   //[REVIEW] No need for empty lines between these two braces
}
