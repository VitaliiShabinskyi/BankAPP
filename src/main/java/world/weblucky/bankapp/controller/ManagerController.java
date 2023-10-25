package world.weblucky.bankapp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.weblucky.bankapp.dto.ManagerDTO;
import world.weblucky.bankapp.service.ManagerService;

@RestController
@RequestMapping("/manager")
@Tag(name = "Manager Controller API")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/{id}")
    public ManagerDTO getManagerById(@PathVariable String id) {
        return managerService.getManagerById(id);
    }
}
