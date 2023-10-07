package jrs.todomongo.todomongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jrs.todomongo.todomongo.service.task.TaskService;
import jrs.todomongo.todomongo.service.task.dto.TaskOut;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class TaskPagesController {

    @Autowired
    private final TaskService taskService;
    
    @GetMapping("/todo")
    public String home(@RequestParam(value = "filter", required = false) String filter,
                        @PageableDefault(sort = "_id", direction = Sort.Direction.DESC) Pageable pagination,
                        ModelMap contents){

        List<TaskOut> tasks = taskService.findTasks(filter, pagination).getContent();
        tasks.forEach(task -> System.out.println(task.getTitle()+" "+task.getIsFinalized()));
        contents.addAttribute("tasks", tasks);

        return "home";
    }
}
