package de.lernenJava.doaa.ToDoList2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int catId;
    @NotFound
    private String catName;
    @OneToMany( mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("category")
     private   List<Task> categoryTasks= new CopyOnWriteArrayList<>();

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
