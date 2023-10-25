package world.weblucky.bankapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.weblucky.bankapp.dto.AgreementDTO;
import world.weblucky.bankapp.service.AgreementService;

@RestController
@RequestMapping("/agreement")
@Tag(name = "Agreement Controller API")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @Operation(summary = "Get Agreement by Agreement.ID")
    @GetMapping("/{id}")
    public AgreementDTO getAgreementById(@PathVariable String id) {
        return agreementService.getAgreementById(id);
    }
}
