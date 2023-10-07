package jrs.todomongo.todomongo.task.fake;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import jrs.todomongo.todomongo.service.task.dto.TaskForm;

@Service
public class TaskTestFake {

    public static TaskForm getTaskForm(){
        return TaskForm
            .builder()
            .title("Task Test Titile")
            .description("Task Test Description")
            .limit(LocalDate.now())
            .build();
    }
}
