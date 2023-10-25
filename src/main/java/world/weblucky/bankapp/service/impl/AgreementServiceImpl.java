package world.weblucky.bankapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import world.weblucky.bankapp.dto.AgreementDTO;
import world.weblucky.bankapp.entity.Agreement;
import world.weblucky.bankapp.mapper.AgreementMapper;
import world.weblucky.bankapp.repository.AgreementRepository;
import world.weblucky.bankapp.service.AgreementService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    private final AgreementMapper agreementMapper;

    @Override
    @Transactional
    public AgreementDTO getAgreementById(String id) {
        Agreement agreement = agreementRepository.findById(Integer.parseInt(id));

        return agreementMapper.agreementToDto(agreement);
    }
}
