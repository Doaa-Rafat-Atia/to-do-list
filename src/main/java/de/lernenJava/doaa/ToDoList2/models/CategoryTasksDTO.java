package de.lernenJava.doaa.ToDoList2.models;

import java.util.List;

public class CategoryTasksDTO { //[REVIEW] why do you use DTO postfix for this class but not the others?
    private String categoryName;
    private List <Tasks>tasks;
    private Tasks task; //[REVIEW] What is this? Why do we need task and taskS?

    public Tasks getTask() {
        return task;
    }   //[REVIEW] Please use Lombok instead

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

    //[REVIEW] please delete unused code
/*public void addTask(Tasks task)
{
    this.tasks.add(task);
}*/


}
