package world.weblucky.bankapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import world.weblucky.bankapp.util.User;

@Data
@NoArgsConstructor
public class ClientDTO implements User {

    private String id;
    private String managerId;

    private String status;
    private String taxCode;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phone;

    private String createdAt;
    private String updatedAt;

}
