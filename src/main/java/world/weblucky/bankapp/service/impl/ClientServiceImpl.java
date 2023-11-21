package world.weblucky.bankapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.entity.Client;
import world.weblucky.bankapp.entity.Manager;
import world.weblucky.bankapp.entity.enums.Status;
import world.weblucky.bankapp.exeption.ManagerNotFoundException;
import world.weblucky.bankapp.mapper.ClientMapper;
import world.weblucky.bankapp.repository.ClientRepository;
import world.weblucky.bankapp.repository.ManagerRepository;
import world.weblucky.bankapp.security.PasswordEncoder;
import world.weblucky.bankapp.service.ClientService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ManagerRepository managerRepository;

    private final ClientMapper clientMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientDTO getClientById(String id) {
        Client client = clientRepository.findById(UUID.fromString(id))
                .orElseThrow();

        return clientMapper.clientToDto(client);
    }

    @Override
    public ClientDTO getClientByEmail(String email) {
        Client client = clientRepository.findByEmail(email);

        return clientMapper.clientToDto(client);
    }

    @Override
    public ClientDTO getClientByPhone(String phone) {
        Client client = clientRepository.findByPhone(phone);

        return clientMapper.clientToDto(client);
    }

    @Override
    public Client createClient(ClientDTO clientDto, BindingResult bindingResult) {
        if (clientRepository.findByEmail(clientDto.getEmail()) != null) {
//            throw new IllegalAccessException("Email already exists");
            bindingResult.rejectValue("email", "error.clientDto", "Email already exists");
            return null;
        }
        Client client = clientMapper.clientToEntity(clientDto);

        Manager manager = managerRepository.findById(1)
                .orElseThrow(() -> new ManagerNotFoundException("Manager not found"));
        client.setManager(manager);

        client.setStatus(Status.valueOf("ACTIVE"));
        client.setPassword(passwordEncoder.encodePassword(clientDto.getPassword()));

        return clientRepository.save(client);
    }

}

