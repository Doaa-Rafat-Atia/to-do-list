package de.lernenJava.doaa.ToDoList2.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class LocalDateTimeDTO {
   private String stringDateTimeDTO;

public LocalDateTime convertStringToDate()
{
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
   LocalDateTime dateTime = LocalDateTime.parse(stringDateTimeDTO, formatter);
return dateTime;
}
}
