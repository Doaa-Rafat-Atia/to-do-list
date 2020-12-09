package de.lernenJava.doaa.ToDoList2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;
    private LocalDateTime dateTime;

    @ManyToOne
    @JsonIgnoreProperties("categoryTasks")
    private Category category;
}
