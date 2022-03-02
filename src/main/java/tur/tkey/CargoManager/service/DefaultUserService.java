package tur.tkey.CargoManager.service;

import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tur.tkey.CargoManager.model.userModel.Role;
import tur.tkey.CargoManager.model.userModel.RoleType;
import tur.tkey.CargoManager.model.userModel.User;
import tur.tkey.CargoManager.repository.RoleRepository;
import tur.tkey.CargoManager.repository.UserRepository;
import tur.tkey.CargoManager.security.service.token.ConfirmationToken;
import tur.tkey.CargoManager.security.service.token.ConfirmationTokenService;


import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultUserService implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ConfirmationTokenService confirmationTokenService;
    private final BCryptPasswordEncoder passwordEncoder;
    private static final String USER_NOT_FOUND_MSG ="user with %s not found";
    private static final String USER_AlREADY_EXISTS_MSG ="user with %s already exists";


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        return user
                .orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public boolean checkEmail(String email){
        if (email!=null) {
            return userRepository.findByEmail(email).isPresent();
        }
        return false;
    }

    @Override
    @Transactional
    public String signUpUser(User user) {//todo->optimize code,split into modules
        if (checkEmail(user.getEmail())){
            //todo->create custom exception or do smth better
            throw new IllegalStateException(String
                    .format(USER_AlREADY_EXISTS_MSG,user.getEmail()));
        }
        String password=passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        //todo
        userRepository.save(user);
        String token=UUID.randomUUID().toString();
        ConfirmationToken confirmationToken=new ConfirmationToken(
                token,
                OffsetDateTime.now(),
                OffsetDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        log.warn(String.format("user with %s name saved",user.getEmail()));
        return confirmationToken.getToken();
    }

    @Override
    public Optional<Role> findRoleName(RoleType roleType) {
        return roleRepository.findByRoleType(roleType);
    }

    @Override
    public void enableUser(String email) {
       userRepository.enableAppUser(email);
    }

//    public void saveRole(Role role) {
//        // TODO: 02.03.2022
//        roleRepository.save(role);
//    }

//    public void addRoleToUser(String email, RoleType roleType) {
//        Optional<User> user=userRepository.findByEmail(email);
//        //todo
//        user.ifPresent(value -> value
//                .getRoles()
//                .add(findRoleName(roleType)
//                        .orElseThrow(() -> new UsernameNotFoundException("role not found"))));
//        throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email));//todo
//    }

    @Override
    public User getUser(String username) {
        //todo
        return null;
    }

    public List<User> getUsers() {
        //todo
        return null;
    }

}
