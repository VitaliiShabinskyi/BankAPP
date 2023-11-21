package world.weblucky.bankapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import world.weblucky.bankapp.dto.TransactionDTO;
import world.weblucky.bankapp.entity.Transaction;

import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "debitAccountId", source = "transaction.debitAccount.id")
    @Mapping(target = "creditAccountId", source = "transaction.creditAccount.id")
    TransactionDTO transactionToDto(Transaction transaction);

    @Mapping(target = "createdAt", ignore = true)
    Transaction transactionToEntity(TransactionDTO transactionDto);

    default Timestamp map(String value) {
        return Timestamp.valueOf(value);
    }

}
