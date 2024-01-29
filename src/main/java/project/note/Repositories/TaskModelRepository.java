package project.note.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import project.note.Controllers.TaskController;
import project.note.Models.TaskModel;

@Repository
public interface TaskModelRepository extends JpaRepository<TaskModel, Long> {

}