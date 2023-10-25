package world.weblucky.bankapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.entity.Client;
import world.weblucky.bankapp.mapper.ClientMapper;
import world.weblucky.bankapp.repository.ClientRepository;
import world.weblucky.bankapp.service.ClientService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

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

}

