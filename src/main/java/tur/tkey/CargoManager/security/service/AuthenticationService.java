package tur.tkey.CargoManager.security.service;

import tur.tkey.CargoManager.payload.request.LoginRequest;
import tur.tkey.CargoManager.payload.request.RegistrationRequest;

public interface AuthenticationService {

    public void register(RegistrationRequest registrationRequest);
    public void login(LoginRequest loginRequest);
}
