package project.note.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.note.Models.TaskModel;
import project.note.Repositories.TaskModelRepository;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskModelRepository taskModelRepository;

    @GetMapping("/tasks")
    public String task(Model model) {
        return "tasks";
    }

    @GetMapping("/tasks/all")
    public String allTasks(Model model) {
        List<TaskModel> tasks = taskModelRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/tasks")
    public String addTask(@RequestParam String text) {
        TaskModel taskModel = new TaskModel();
        taskModel.setText(text);
        taskModelRepository.save(taskModel);
        return "redirect:/tasks/all";
    }

    @PostMapping("/tasks/delete")
    public String deleteTask(@RequestParam Long taskId) {
        taskModelRepository.deleteById(taskId);
        return "redirect:/tasks/all";
    }
}