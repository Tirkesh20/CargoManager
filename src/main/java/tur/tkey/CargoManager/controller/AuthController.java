package tur.tkey.CargoManager.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tur.tkey.CargoManager.security.registration.RegistrationRequest;

@RestController
public class AuthController {

    public  String registration(@RequestBody RegistrationRequest registrationRequest){
        return "work";
    }
}
