package world.weblucky.bankapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AccountDTO {

    private UUID id;
    private String clientId;

    private String name;
    private String type;
    private String status;
    private String balance;
    private String currencyCode;

    private String createdAt;
    private String updatedAt;

}
