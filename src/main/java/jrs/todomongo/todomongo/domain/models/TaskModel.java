package jrs.todomongo.todomongo.domain.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jrs.todomongo.todomongo.service.task.dto.TaskForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document("task")
public class TaskModel {
    
    @Id
    private String id;

    private String title;

    private String description;

    private LocalDate limit;

    private Boolean isFinalized;

    private LocalDateTime createdIn;

    public static TaskModel toModel(TaskForm form){
        if(form == null) return null;

        return TaskModel
            .builder()
            .description(form.getDescription())
            .limit(form.getLimit())
            .title(form.getTitle())
            .isFinalized(false)
            .createdIn(LocalDateTime.now())
            .build();
    }
}
