package world.weblucky.bankapp.service;

import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.ManagerDTO;

@Service
public interface ManagerService {
    ManagerDTO getManagerById(String id);

    ManagerDTO getManagerByEmail(String email);
}
