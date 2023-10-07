package jrs.todomongo.todomongo.service.task.impl;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jrs.todomongo.todomongo.domain.models.TaskModel;
import jrs.todomongo.todomongo.domain.repositories.TaskRepository;
import jrs.todomongo.todomongo.exception.EntityNotFoundException;
import jrs.todomongo.todomongo.exception.OperationNotValidException;
import jrs.todomongo.todomongo.service.task.TaskService;
import jrs.todomongo.todomongo.service.task.dto.TaskForm;
import jrs.todomongo.todomongo.service.task.dto.TaskOut;
import jrs.todomongo.todomongo.service.task.dto.TaskUpdateForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskOut createTask(TaskForm form) {
        TaskModel task = TaskModel.toModel(form);

        task = taskRepository.save(task);

        return TaskOut.toDto(task);
    }

    @Override
    public TaskOut updateTask(String taskId, TaskUpdateForm update) {
        Optional<TaskModel> taskModelOptional = taskRepository.findById(taskId);
        if(taskModelOptional.isEmpty()){
            throw new EntityNotFoundException("Task not found for id "+taskId);
        }

        TaskModel task = taskModelOptional.get();

        if(update.getLimit().isBefore(LocalDate.now())){
            throw new OperationNotValidException("Task limit cannot be a past date");
        }

       task.setDescription(update.getDescription());
       task.setIsFinalized(update.getIsFinalized());
       task.setLimit(update.getLimit());
       task.setTitle(update.getTitle());
       taskRepository.save(task);

        return TaskOut.toDto(task);
    }

    @Override
    public TaskOut findTaskById(String taskId) {
        Optional<TaskModel> taskModelOptional = taskRepository.findById(taskId);
        if(taskModelOptional.isEmpty()){
            throw new EntityNotFoundException("Task not found for id "+taskId);
        }

        return TaskOut.toDto(taskModelOptional.get());
    }

    @Override
    public Page<TaskOut> findTasks(String filter, Pageable pagination) {
        Page<TaskModel> results = null;
        if(Objects.isNull(filter)){
            results = taskRepository.findAll(pagination);
        }else {
            results = taskRepository.findByTitleOrDescriptionContainingIgnoreCase(filter, filter, pagination);
        }

        return results.map(task -> TaskOut.toDto(task));
    }

    @Override
    public void removeTask(String taskId) {
        TaskModel task = taskRepository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task not found for id "+taskId));

        taskRepository.delete(task);
        return;
    }

}
