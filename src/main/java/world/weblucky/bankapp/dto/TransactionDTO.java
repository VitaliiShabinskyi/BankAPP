package world.weblucky.bankapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionDTO {

    private String id;
    private String debitAccountId;
    private String creditAccountId;

    private String type;
    private String amount;
    private String description;

    private String createdAt;

}
