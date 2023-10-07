package jrs.todomongo.todomongo.service.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jrs.todomongo.todomongo.service.task.dto.TaskForm;
import jrs.todomongo.todomongo.service.task.dto.TaskOut;
import jrs.todomongo.todomongo.service.task.dto.TaskUpdateForm;

public interface TaskService {
    TaskOut createTask(TaskForm form);
    TaskOut updateTask(String taskId, TaskUpdateForm update);
    TaskOut findTaskById(String taskId);
    Page<TaskOut> findTasks(String filter, Pageable pagination);
    void removeTask(String taskId);
}
