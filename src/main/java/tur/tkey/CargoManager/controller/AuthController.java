package tur.tkey.CargoManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tur.tkey.CargoManager.model.userModel.User;
import tur.tkey.CargoManager.payload.request.LoginRequest;
import tur.tkey.CargoManager.payload.request.RegistrationRequest;
import tur.tkey.CargoManager.payload.response.JwtResponse;
import tur.tkey.CargoManager.security.jwt.JwtUtil;
import tur.tkey.CargoManager.security.service.AuthenticationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public  ResponseEntity<User> registration(@RequestBody RegistrationRequest registrationRequest){
        authenticationService.register(registrationRequest);
        return ResponseEntity.ok().build();//todo

    }

    @GetMapping("/confirm")
    public void confirmEmail(@RequestParam String token){
        authenticationService.confirmToken(token);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest loginRequest){
        // TODO: 02.03.2022 -> need to move logic to service layer
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);

        User user = (User) authentication.getPrincipal();
        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                user.getId(),
                user.getUsername(),
                roles));
    }
}
