package world.weblucky.bankapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.ManagerDTO;
import world.weblucky.bankapp.entity.Manager;
import world.weblucky.bankapp.mapper.ManagerMapper;
import world.weblucky.bankapp.repository.ManagerRepository;
import world.weblucky.bankapp.service.ManagerService;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    private final ManagerMapper managerMapper;

    @Override
    public ManagerDTO getManagerById(String id) {
        Manager manager = managerRepository.findById(Integer.valueOf(id)).orElseThrow();

        return managerMapper.managerToDto(manager);
    }

    @Override
    public ManagerDTO getManagerByEmail(String email) {
        Manager manager = managerRepository.findByEmail(email);

        return managerMapper.managerToDto(manager);
    }
}
