package world.weblucky.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.weblucky.bankapp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
