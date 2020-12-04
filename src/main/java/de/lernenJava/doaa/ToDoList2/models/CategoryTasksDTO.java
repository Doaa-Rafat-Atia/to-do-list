package de.lernenJava.doaa.ToDoList2.models;

import java.util.List;

public class CategoryTasksDTO {
    private String categoryName;
    private List <Tasks>tasks;
    private Tasks task;

    public Tasks getTask() {
        return task;
    }

    public void setTask(Tasks task) {
        this.task = task;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

/*public void addTask(Tasks task)
{
    this.tasks.add(task);
}*/


}
