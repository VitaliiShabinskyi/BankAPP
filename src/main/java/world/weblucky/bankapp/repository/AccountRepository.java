package world.weblucky.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import world.weblucky.bankapp.entity.Account;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("from Account where client.id = :clientId")
    List<Account> findAllAccountsOfClient(UUID clientId);

//    List<Account> findById(UUID id);

}
