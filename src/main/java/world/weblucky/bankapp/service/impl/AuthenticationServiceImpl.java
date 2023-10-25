package world.weblucky.bankapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.weblucky.bankapp.dto.ClientDTO;
import world.weblucky.bankapp.dto.ManagerDTO;
import world.weblucky.bankapp.service.AuthenticationService;
import world.weblucky.bankapp.service.ClientService;
import world.weblucky.bankapp.service.ManagerService;
import world.weblucky.bankapp.security.PasswordEncoder;
import world.weblucky.bankapp.util.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final ClientService clientService;

    private final ManagerService managerService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User authenticateUser(String username, String password) {
        ClientDTO clientDto = null;
        ManagerDTO managerDto = null;

        if (validateEmail(username)) {
            clientDto = clientService.getClientByEmail(username);
            managerDto = managerService.getManagerByEmail(username);
        }

        if (validatePhone(username)) {
            clientDto = clientService.getClientByPhone(username);
        }

        if (clientDto != null && passwordEncoder.matchPassword(password, clientDto.getPassword())) {
            return clientDto;
        }

        if (managerDto != null && passwordEncoder.matchPassword(password, managerDto.getPassword())) {
            return managerDto;
        }

        return null;
    }

    private boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validatePhone(String phone) {
        String regex = "^[+]\\d{8,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
