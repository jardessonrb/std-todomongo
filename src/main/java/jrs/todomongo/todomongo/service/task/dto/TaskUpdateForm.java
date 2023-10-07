package jrs.todomongo.todomongo.service.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskUpdateForm extends TaskForm {

    private Boolean isFinalized;
    
}
