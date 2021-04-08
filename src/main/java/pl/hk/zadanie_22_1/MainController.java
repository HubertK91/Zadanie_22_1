package pl.hk.zadanie_22_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private MailService mailService;

    public MainController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("sender",new Sender());
        return "contact";
    }

    @PostMapping("/sent")
    public String sendMail(Sender sender) {
        mailService.sendMail(sender);
        return "home";
    }
}
