package tur.tkey.CargoManager.security.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tur.tkey.CargoManager.model.userModel.User;
import tur.tkey.CargoManager.payload.request.LoginRequest;
import tur.tkey.CargoManager.payload.request.RegistrationRequest;
import tur.tkey.CargoManager.service.UserService;
import tur.tkey.CargoManager.validator.DefaultAuthValidator;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultAuthService implements AuthenticationService{

    private final UserService userService;
    private final DefaultAuthValidator authValidator;

    @Override
    public boolean register(RegistrationRequest request) {
        //todo->improve logic and ad validation menthods
        boolean valid=authValidator.test(request.getEmail());
        if (!valid){
            throw new IllegalStateException("emails is not valid");
        }
        log.warn("user valid");
        return userService.signUpUser(new User(
                request.getFirstName(),
                request.getLastname(),
                request.getEmail(),
                request.getPassword()
        ));
    }

    @Override
    public boolean login(LoginRequest request) {
        return false;
    }
}
