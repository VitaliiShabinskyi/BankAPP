package world.weblucky.bankapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import world.weblucky.bankapp.dto.AgreementDTO;
import world.weblucky.bankapp.entity.Account;
import world.weblucky.bankapp.entity.Agreement;
import world.weblucky.bankapp.entity.Product;

import java.sql.Timestamp;

@Mapper(componentModel = "spring",
        imports = {Account.class, Product.class},
        uses = {AccountMapper.class, ProductMapper.class})
//@Component
//@Mapper(componentModel = "spring")
public interface AgreementMapper {

    @Mapping(target = "accountId", source = "agreement.account.id")
    @Mapping(target = "productId", source = "agreement.product.id")
    AgreementDTO agreementToDto(Agreement agreement);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Agreement agreementToEntity(AgreementDTO agreementDto);

    default Timestamp map(String value) {
        return Timestamp.valueOf(value);
    }
}
