package tur.tkey.CargoManager.security.service;

import tur.tkey.CargoManager.payload.request.LoginRequest;
import tur.tkey.CargoManager.payload.request.RegistrationRequest;

public interface AuthenticationService {

    String register(RegistrationRequest registrationRequest);
    boolean login(LoginRequest loginRequest);
    String confirmToken(String token);
}
