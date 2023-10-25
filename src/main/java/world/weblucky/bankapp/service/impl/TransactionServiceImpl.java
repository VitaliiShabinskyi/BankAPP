package world.weblucky.bankapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.TransactionDTO;
import world.weblucky.bankapp.mapper.TransactionMapper;
import world.weblucky.bankapp.repository.TransactionRepository;
import world.weblucky.bankapp.service.TransactionService;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    @Override
    public TransactionDTO getTransactionById(String id) {
        return null;
    }
}
