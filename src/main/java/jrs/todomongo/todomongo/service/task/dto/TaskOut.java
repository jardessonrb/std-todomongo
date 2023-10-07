package jrs.todomongo.todomongo.service.task.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jrs.todomongo.todomongo.domain.models.TaskModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaskOut {

    private String id;
    
    private String title;

    private String description;

    private LocalDate limit;

    private Boolean isFinalized;

    private LocalDateTime createdIn;

    public static TaskOut toDto(TaskModel model){
        if(model == null) return null;

        return TaskOut
            .builder()
            .id(model.getId())
            .description(model.getDescription())
            .title(model.getTitle())
            .limit(model.getLimit())
            .isFinalized(model.getIsFinalized())
            .createdIn(model.getCreatedIn())
            .build();
    }
}
