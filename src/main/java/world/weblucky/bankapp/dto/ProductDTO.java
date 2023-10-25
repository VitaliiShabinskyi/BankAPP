package world.weblucky.bankapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

    private String id;
    private String managerId;

    private String name;
    private String status;
    private String currencyCode;
    private String interestRate;
    private String limit;

    private String createdAt;
    private String updatedAt;

}
