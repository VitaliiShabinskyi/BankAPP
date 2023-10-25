package world.weblucky.bankapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import world.weblucky.bankapp.util.User;

@Data
@NoArgsConstructor
public class ManagerDTO implements User {

    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String status;

    private String createdAt;
    private String updatedAt;

    @Override
    public String getPhone() {
        return null;
    }

}
