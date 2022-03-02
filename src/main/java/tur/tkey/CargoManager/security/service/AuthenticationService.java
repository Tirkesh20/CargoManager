package tur.tkey.CargoManager.security.service;

import tur.tkey.CargoManager.payload.request.LoginRequest;
import tur.tkey.CargoManager.payload.request.RegistrationRequest;

public interface AuthenticationService {

    public boolean register(RegistrationRequest registrationRequest);
    public boolean login(LoginRequest loginRequest);
}
