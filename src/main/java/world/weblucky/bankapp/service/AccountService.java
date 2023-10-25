package world.weblucky.bankapp.service;

import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.AccountDTO;

import java.util.List;

@Service
public interface AccountService {

//    Account createAccount(AccountDTO accountDTO);

    void createAccount(AccountDTO accountDto);

    AccountDTO getAccountById(String id);

    List<AccountDTO> getAllAccountsOfClient(String clientId);
}
