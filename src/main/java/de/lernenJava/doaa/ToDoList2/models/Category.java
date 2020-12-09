package de.lernenJava.doaa.ToDoList2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;
    @OneToMany( mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("category")
    private List<Task> categoryTasks= new CopyOnWriteArrayList<>();

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

    public List<Task> getCategoryTasks() {
        return categoryTasks;
    }

    public void setCategoryTasks(List<Task> categoryTasks) {
        this.categoryTasks = categoryTasks;
    }

    public void addTask(Task task)
    {
        if (categoryTasks.isEmpty())
        {
            categoryTasks.add(task);
        }
        else
            categoryTasks.add(task);
    }


}
