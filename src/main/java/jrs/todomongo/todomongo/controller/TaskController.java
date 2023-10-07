package jrs.todomongo.todomongo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jrs.todomongo.todomongo.service.task.TaskService;
import jrs.todomongo.todomongo.service.task.dto.TaskForm;
import jrs.todomongo.todomongo.service.task.dto.TaskOut;
import jrs.todomongo.todomongo.service.task.dto.TaskUpdateForm;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    
    @PostMapping
    public ResponseEntity<TaskOut> createTask(@RequestBody TaskForm form, UriComponentsBuilder uriComponentsBuilder){
        TaskOut taskOut = taskService.createTask(form);

        URI uriOfTaskCreated = uriComponentsBuilder.path("/{taskId}").buildAndExpand(taskOut.getId()).toUri();

        return ResponseEntity.created(uriOfTaskCreated).body(taskOut);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskOut> updateTask(@PathVariable(name = "taskId") String taskId, @RequestBody TaskUpdateForm update){
        return ResponseEntity.ok(taskService.updateTask(taskId, update));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskOut> findTask(@PathVariable(name = "taskId") String taskId){
        return ResponseEntity.ok(taskService.findTaskById(taskId));
    }
    
    @GetMapping
    public ResponseEntity<Page<TaskOut>> findAll(@RequestParam(name = "filter", required = false) String filter,
    @PageableDefault(page = 0, size = 10, direction = Direction.DESC, sort = "title") Pageable pagination){
        return ResponseEntity.ok(taskService.findTasks(filter, pagination));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> removeTask(@PathVariable(name = "taskId") String taskId){
        taskService.removeTask(taskId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
