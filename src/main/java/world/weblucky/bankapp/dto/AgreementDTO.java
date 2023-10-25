package world.weblucky.bankapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgreementDTO {

    private String id;
    private String accountId;
    private String productId;

    private String interestRate;
    private String status;
    private String sum;

    private String createdAt;
    private String updatedAt;

}
