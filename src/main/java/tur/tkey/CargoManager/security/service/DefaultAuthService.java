package tur.tkey.CargoManager.security.service;

import org.springframework.stereotype.Service;
import tur.tkey.CargoManager.payload.request.LoginRequest;
import tur.tkey.CargoManager.payload.request.RegistrationRequest;

@Service
public class DefaultAuthService implements AuthenticationService{
    @Override
    public void register(RegistrationRequest registrationRequest) {

    }

    @Override
    public void login(LoginRequest loginRequest) {

    }
}
