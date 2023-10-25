package world.weblucky.bankapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.weblucky.bankapp.dto.AccountDTO;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.service.AccountService;
import world.weblucky.bankapp.service.ClientService;

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

    @Operation(summary = "Get all clients accounts by Client.ID")
    @GetMapping("/{id}/accounts")
    public List<AccountDTO> getAllAccounts(@PathVariable String id) {
        return accountService.getAllAccountsOfClient(id);
    }


}
