package de.lernenJava.doaa.ToDoList2.dataAccessObject;
//[REVIEW] please remove "Object" from package name
// Also, package names should be all in lower case as per Java naming conventions.
// https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html

import de.lernenJava.doaa.ToDoList2.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Integer> {    //[REVIEW] spaces :)
    @Override
    List<Category> findAll();
}
