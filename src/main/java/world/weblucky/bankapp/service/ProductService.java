package world.weblucky.bankapp.service;

import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.ProductDTO;

@Service
public interface ProductService {
    ProductDTO getProductById(String id);
}
