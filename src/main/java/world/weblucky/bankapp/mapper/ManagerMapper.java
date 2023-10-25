package world.weblucky.bankapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import world.weblucky.bankapp.dto.ManagerDTO;
import world.weblucky.bankapp.entity.Manager;

import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

//    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "dd-MM-yyyy HH:mm")
//    @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "dd-MM-yyyy HH:mm")
    ManagerDTO managerToDto(Manager manager);

//    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Manager managerToEntity(ManagerDTO managerDto);

    default Timestamp map(String value) {
        return Timestamp.valueOf(value);
    }

}
