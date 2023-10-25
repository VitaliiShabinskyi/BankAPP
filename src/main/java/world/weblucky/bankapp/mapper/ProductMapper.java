package world.weblucky.bankapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import world.weblucky.bankapp.dto.ProductDTO;
import world.weblucky.bankapp.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "managerId", source = "product.manager.id")
    ProductDTO productToDto(Product product);

    Product productToEntity(ProductDTO productDto);

}
