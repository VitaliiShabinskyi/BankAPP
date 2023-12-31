package world.weblucky.bankapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import world.weblucky.bankapp.dto.AccountDTO;
import world.weblucky.bankapp.entity.Account;
import world.weblucky.bankapp.entity.Client;

import java.sql.Timestamp;
import java.util.List;

@Mapper(componentModel = "spring", imports = {Client.class}, uses = {ClientMapper.class, AgreementMapper.class})
public interface AccountMapper {

    @Mapping(target = "clientId", source = "client.id")
    AccountDTO accountToDto(Account account);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Account accountToEntity(AccountDTO accountDto);

    List<AccountDTO> accountsToListDto(List<Account> accounts);

    default Timestamp map(String value) {
        return Timestamp.valueOf(value);
    }
}
