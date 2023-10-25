package world.weblucky.bankapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.entity.Client;

import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface ClientMapper {

//    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "dd-MM-yyyy HH:mm")
//    @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "dd-MM-yyyy HH:mm")
    @Mapping(target = "managerId", source = "client.manager.id")
    ClientDTO clientToDto(Client client);

//    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Client clientToEntity(ClientDTO clientDto);

    default Timestamp map(String value) {
        return Timestamp.valueOf(value);
    }

}
