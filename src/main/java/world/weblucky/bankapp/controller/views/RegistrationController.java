package world.weblucky.bankapp.controller.views;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.entity.Client;
import world.weblucky.bankapp.service.ClientService;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class RegistrationController {

    private final ClientService clientService;

    @GetMapping("/signin")
    public String getRegisterPage(Model model) {
        model.addAttribute("title", "Registration page | LuckyBank APP");
        model.addAttribute("clientDto", new ClientDTO());
        return "signin";
    }

    @PostMapping("/signin")
    public String registerNewClient(@Valid @ModelAttribute("clientDto") ClientDTO clientDto,
                                    BindingResult bindingResult,
                                    Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("clientDto", clientDto);
            return "signin";
        }

        Client registeredClient = clientService.createClient(clientDto, bindingResult);

        if (registeredClient == null) {
            model.addAttribute("clientDto", clientDto);
            return "signin";
        }

        return "redirect:/login";
    }

}
