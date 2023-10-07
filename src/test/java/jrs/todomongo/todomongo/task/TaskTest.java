package jrs.todomongo.todomongo.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.client.MongoClient;

import jrs.todomongo.todomongo.service.task.TaskService;
import jrs.todomongo.todomongo.service.task.dto.TaskForm;
import jrs.todomongo.todomongo.service.task.dto.TaskOut;
import jrs.todomongo.todomongo.task.fake.TaskTestFake;


@ActiveProfiles(profiles = {"test"})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskTest {
    
    @Autowired
    private TaskService taskService;

    @DisplayName("Let's test creating a task")
    @Test
    @DirtiesContext
    public void createTaskTest() {
        TaskForm form = TaskTestFake.getTaskForm();

        TaskOut taskOut = taskService.createTask(form);

        assertEquals(taskOut.getTitle(), form.getTitle());
        assertNotNull(taskOut.getId());
    }   
}
