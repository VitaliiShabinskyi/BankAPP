package world.weblucky.bankapp.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.entity.Client;

@Service
public interface ClientService {

    ClientDTO getClientById(String id);

    ClientDTO getClientByEmail(String email);

    ClientDTO getClientByPhone(String username);


    Client createClient(ClientDTO clientDto, BindingResult bindingResult);
}
