package world.weblucky.bankapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import world.weblucky.bankapp.util.User;

@Data
@NoArgsConstructor
public class ClientDTO implements User {

    private String id;
    private String managerId;

    private String status;

    @Size(min = 6, max = 20, message = "Tax Code must contain from 6 to 20 characters")
    private String taxCode;

    @Size(min = 2, max = 50, message = "First Name must contain from 2 to 50 characters")
    private String firstName;

    @Size(min = 2, max = 50, message = "Last Name must contain from 2 to 50 characters")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email")
    private String email;

    @Size(min = 6, max = 256, message = "Password should have at least 6 characters")
    private String password;

    @Size(min = 2, max = 80, message = "Address must contain from 2 to 80 characters")
    private String address;

    @Size(min = 6, max = 20, message = "Phone should have at least 6 digits")
    private String phone;

    private String createdAt;
    private String updatedAt;

}
