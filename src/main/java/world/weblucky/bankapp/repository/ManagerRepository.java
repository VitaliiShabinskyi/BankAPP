package world.weblucky.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.weblucky.bankapp.entity.Manager;

@Repository
public interface ManagerRepository  extends JpaRepository<Manager, Integer> {

    Manager findByEmail(String email);
}
