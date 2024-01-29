package project.note.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.note.Models.RegistrationModel;

import java.util.List;

@Repository
public interface RegistrationModelRepository extends JpaRepository<RegistrationModel, Long> {
    boolean existsByLoginAndPassword(String login, String password);
}