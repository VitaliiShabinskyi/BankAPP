package world.weblucky.bankapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import world.weblucky.bankapp.dto.AccountDTO;
import world.weblucky.bankapp.entity.Account;
import world.weblucky.bankapp.entity.Client;
import world.weblucky.bankapp.exeption.ClientNotFoundException;
import world.weblucky.bankapp.mapper.AccountMapper;
import world.weblucky.bankapp.repository.AccountRepository;
import world.weblucky.bankapp.repository.ClientRepository;
import world.weblucky.bankapp.service.AccountService;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public void createAccount(AccountDTO accountDto) {

        Client client = clientRepository.findById(UUID.fromString(accountDto.getClientId()))
                .orElseThrow(() -> new ClientNotFoundException("Client ID: " + accountDto.getClientId() + " not found"));

        Account account = accountMapper.accountToEntity(accountDto);
        account.setClient(client);
        account.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        account.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        accountRepository.save(account);
    }

    @Override
    public AccountDTO getAccountById(UUID id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client ID: " + id + " not found"));

        return accountMapper.accountToDto(account);
    }

    @Override
    public List<AccountDTO> getAllAccountsOfClient(String clientId) {
        return accountMapper.accountsToListDto(accountRepository.findAllAccountsOfClient(clientId));
    }

}
