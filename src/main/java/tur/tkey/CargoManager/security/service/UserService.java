package tur.tkey.CargoManager.security.service;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tur.tkey.CargoManager.model.userModel.Role;
import tur.tkey.CargoManager.model.userModel.RoleType;
import tur.tkey.CargoManager.model.userModel.User;
import tur.tkey.CargoManager.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService , tur.tkey.CargoManager.service.UserService {

    private static final String USER_NOT_FOUND_MSG ="user with %s not found";

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        return user
                .orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void saveRole(Role role) {

    }

    @Override
    public void addRoleToUser(String username, RoleType role) {

    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> getUser() {
        return null;
    }
}
