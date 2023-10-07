package jrs.todomongo.todomongo.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import jrs.todomongo.todomongo.domain.models.TaskModel;

@Repository
public interface TaskRepository extends MongoRepository<TaskModel, String>
{
    Page<TaskModel> findByTitleOrDescriptionContainingIgnoreCase(String filterForTitle, String filterForDescription, Pageable pagination);
}
