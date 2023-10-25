package world.weblucky.bankapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.weblucky.bankapp.dto.TransactionDTO;
import world.weblucky.bankapp.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@Tag(name = "Transaction Controller API")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @Operation(summary = "Get transaction by Id")
    @GetMapping("/{id}")
    public TransactionDTO getTransactionById(@PathVariable String id) {
        return transactionService.getTransactionById(id);
    }
}
