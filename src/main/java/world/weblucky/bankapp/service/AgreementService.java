package world.weblucky.bankapp.service;

import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.AgreementDTO;

@Service
public interface AgreementService {
    AgreementDTO getAgreementById(String id);

}
