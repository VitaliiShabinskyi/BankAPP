package world.weblucky.bankapp.service;

import org.springframework.stereotype.Service;
import world.weblucky.bankapp.util.User;

@Service
public interface AuthenticationService {
    User authenticateUser(String username, String password);
}
