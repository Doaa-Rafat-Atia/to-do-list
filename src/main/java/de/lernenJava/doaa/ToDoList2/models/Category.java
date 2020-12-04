package de.lernenJava.doaa.ToDoList2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Tasks> categoryTasks;
  // private Tasks task;

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

    public void addTask(Tasks task)
    {
        if (categoryTasks==null)
        {
            categoryTasks =new CopyOnWriteArrayList<>();
            categoryTasks.add(task);

        }
        else
            categoryTasks.add(task);
    }


}
