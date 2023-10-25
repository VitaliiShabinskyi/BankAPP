package world.weblucky.bankapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.ProductDTO;
import world.weblucky.bankapp.entity.Product;
import world.weblucky.bankapp.mapper.ProductMapper;
import world.weblucky.bankapp.repository.ProductRepository;
import world.weblucky.bankapp.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public ProductDTO getProductById(String id) {
        Product product = productRepository.findById(Integer.valueOf(id))
                .orElseThrow();

        return productMapper.productToDto(product);
    }
}
