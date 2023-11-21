package world.weblucky.bankapp.service;

import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.AccountDTO;

import java.util.List;
import java.util.UUID;

@Service
public interface AccountService {

//    Account createAccount(AccountDTO accountDTO);

    void createAccount(AccountDTO accountDto);

    AccountDTO getAccountById(UUID id);

    List<AccountDTO> getAllAccountsOfClient(String clientId);
}
