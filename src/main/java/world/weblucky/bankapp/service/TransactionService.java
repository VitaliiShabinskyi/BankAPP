package world.weblucky.bankapp.service;

import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.TransactionDTO;

@Service
public interface TransactionService {

    TransactionDTO getTransactionById(String id);
}
