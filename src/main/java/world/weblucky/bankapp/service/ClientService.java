package world.weblucky.bankapp.service;

import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.ClientDTO;

@Service
public interface ClientService {

    ClientDTO getClientById(String id);

    ClientDTO getClientByEmail(String email);

    ClientDTO getClientByPhone(String username);
}
