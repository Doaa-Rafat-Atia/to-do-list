package de.lernenJava.doaa.ToDoList2.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotFound
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @NotFound
    private LocalDateTime dateTime;

    @ManyToOne
    @JsonIgnoreProperties("categoryTasks")
    private Category category;
}
