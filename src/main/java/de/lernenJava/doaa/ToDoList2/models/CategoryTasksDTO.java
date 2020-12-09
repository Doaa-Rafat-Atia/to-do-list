package de.lernenJava.doaa.ToDoList2.models;

import java.util.List;

public class CategoryTasksDTO {
    private String categoryName;
    private List <Task>tasks;
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

/*public void addTask(Tasks task)
{
    this.tasks.add(task);
}*/


}
