package world.weblucky.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.weblucky.bankapp.entity.Agreement;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

    Agreement findById(int id);

}
