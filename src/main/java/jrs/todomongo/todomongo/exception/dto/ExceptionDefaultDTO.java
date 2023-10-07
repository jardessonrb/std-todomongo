package jrs.todomongo.todomongo.exception.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ExceptionDefaultDTO {
    
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant timestamp;

    private int status;

    private String message;

    private String path;

    public ExceptionDefaultDTO(Instant timestamp, int statusCode, String message, String path){
        this.message = message;
        this.status = statusCode;
        this.path = path;
        this.timestamp = timestamp;
    }
}
