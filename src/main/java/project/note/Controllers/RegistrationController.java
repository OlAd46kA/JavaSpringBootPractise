package project.note.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.note.Models.RegistrationModel;
import project.note.Repositories.RegistrationModelRepository;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationModelRepository registrationModelRepository;


    @GetMapping("/register")
    public String register (Model model){
        return "register";
    }

    @GetMapping("/login")
    public String login (Model model){
        return "login";
    }
    @GetMapping("logged")
    public String logged (@RequestParam String login, @RequestParam String password, Model model){
        boolean userExists = registrationModelRepository.existsByLoginAndPassword(login, password);
        if (userExists) {
            return "redirect:/tasks";
        }
        else{
            return "redirect:/register";
        }
    }

    @GetMapping("/home")
    public String home (Model model){
        return "home";
    }

    @PostMapping("/register")
    public String register (@RequestParam String login, @RequestParam String password){
        boolean userExists = registrationModelRepository.existsByLoginAndPassword(login, password);
        if (userExists) {
            return "redirect:/login";
        } else {
            RegistrationModel registrationModel = new RegistrationModel();
            registrationModel.setLogin(login);
            registrationModel.setPassword(password);
            registrationModelRepository.save(registrationModel);

            return "redirect:/login";
        }
    }
}
