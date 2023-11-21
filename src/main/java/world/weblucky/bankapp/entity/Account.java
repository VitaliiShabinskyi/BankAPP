package world.weblucky.bankapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import world.weblucky.bankapp.entity.enums.AccountType;
import world.weblucky.bankapp.entity.enums.CurrencyCode;
import jakarta.persistence.*;
import world.weblucky.bankapp.entity.enums.Status;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "accounts")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Client client; // UUID

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AccountType type; // -> enum

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status; // -> enum

    @Column(name = "balance", columnDefinition = "DECIMAL(15,2) DEFAULT 0")
    private BigDecimal balance;

    @Column(name = "currency_code")
    @Enumerated(EnumType.STRING)
    private CurrencyCode currencyCode; // -> enum

    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @JsonIgnore
//    @OneToMany(mappedBy = "account")
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Agreement> agreements;

    @JsonIgnore
//    @OneToMany(mappedBy = "debitAccount")
    @OneToMany(mappedBy = "debitAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> debitTransactions;

    @JsonIgnore
//    @OneToMany(mappedBy = "creditAccount")
    @OneToMany(mappedBy = "creditAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> creditTransactions;

    public Account(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
