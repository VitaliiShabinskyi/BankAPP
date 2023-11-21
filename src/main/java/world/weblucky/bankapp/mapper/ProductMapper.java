package world.weblucky.bankapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import world.weblucky.bankapp.dto.ProductDTO;
import world.weblucky.bankapp.entity.Product;

import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "managerId", source = "product.manager.id")
    ProductDTO productToDto(Product product);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Product productToEntity(ProductDTO productDto);

    default Timestamp map(String value) {
        return Timestamp.valueOf(value);
    }

}
