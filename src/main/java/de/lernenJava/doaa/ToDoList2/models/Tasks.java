package de.lernenJava.doaa.ToDoList2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tasks {    //[REVIEW] Please use singular form for class names (task, not taskS)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String taskDescription; //[REVIEW] please remove the prefix "task"; It is made redundant by class name.
    private Date taskDate;  //[REVIEW] please use Java 8's LocalDate or ZonedDate.
    // They are much better than the legacy Date classes.
    @ManyToOne
    @JsonIgnoreProperties("categoryTasks")
    private Category category;

    public String getTaskDescription() {
        return taskDescription;
    }   //[REVIEW] Lombok :D

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
