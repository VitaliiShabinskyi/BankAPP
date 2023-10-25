package world.weblucky.bankapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.dto.ManagerDTO;
import world.weblucky.bankapp.service.AuthenticationService;
import world.weblucky.bankapp.util.User;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationService authenticationService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = authenticationService.authenticateUser(username, password);
        if (user != null) {
            if (user instanceof ClientDTO) {
                return "redirect:/client/" + ((ClientDTO) user).getId();
            }
            if (user instanceof ManagerDTO) {
                return "redirect:/manager/" + ((ManagerDTO) user).getId();
            }
        }

        model.addAttribute("error", "Invalid login or password. Please try again.");
        return "login";
    }
}
