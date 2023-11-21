package world.weblucky.bankapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import world.weblucky.bankapp.dto.AccountDTO;
import world.weblucky.bankapp.service.AccountService;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@Tag(name = "Account Controller API")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @Operation(summary = "Create new account")
    @PostMapping
    public void createAccount(@RequestBody AccountDTO accountDTO) {
        accountService.createAccount(accountDTO);
    }

    @Operation(summary = "Get account by Account.ID")
    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable("id") String id) {
        return accountService.getAccountById(UUID.fromString(id));
    }

    @Operation(summary = "Close account")
    @GetMapping("/{id}/close")
    public void closeAccount(@PathVariable String id) {

    }

}