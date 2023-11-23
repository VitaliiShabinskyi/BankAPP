package world.weblucky.bankapp.controller.views;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.dto.ManagerDTO;
import world.weblucky.bankapp.entity.Client;
import world.weblucky.bankapp.service.AuthenticationService;
import world.weblucky.bankapp.service.ClientService;
import world.weblucky.bankapp.util.User;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationService authenticationService;

    private final ClientService clientService;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("title", "Login page | LuckyBank APP");

        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = authenticationService.authenticateUser(username, password);
        if (user != null) {
            if (user instanceof ClientDTO) {
                model.addAttribute("client", ((ClientDTO) user).getId());
//                return "redirect:/client/" + ((ClientDTO) user).getId();
                return "redirect:/client";
            }
            if (user instanceof ManagerDTO) {
                return "redirect:/manager/" + ((ManagerDTO) user).getId();
            }
        }

        model.addAttribute("error", "Invalid login or password. Please try again.");
        return "login";
    }

}
