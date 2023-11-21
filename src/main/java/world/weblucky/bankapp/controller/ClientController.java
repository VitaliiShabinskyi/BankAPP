package world.weblucky.bankapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import world.weblucky.bankapp.dto.AccountDTO;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.entity.Client;
import world.weblucky.bankapp.service.AccountService;
import world.weblucky.bankapp.service.ClientService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/client")
@Tag(name = "Client Controller API")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final AccountService accountService;

    @Operation(summary = "Get client by Client.ID")
    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/")
    public String getClientInfo(Model model, Principal principal) {
        ClientDTO clientDto = clientService.getClientById(principal.getName());
        model.addAttribute("client", clientDto);
        return "client";
    }

    @Operation(summary = "Get all clients accounts by Client.ID")
    @GetMapping("/{id}/accounts")
    public List<AccountDTO> getAllAccounts(@PathVariable String id) {
        return accountService.getAllAccountsOfClient(id);
    }


}
