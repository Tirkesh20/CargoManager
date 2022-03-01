package tur.tkey.CargoManager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tur.tkey.CargoManager.model.userModel.Role;
import tur.tkey.CargoManager.model.userModel.RoleType;
import tur.tkey.CargoManager.model.userModel.User;
import tur.tkey.CargoManager.repository.RoleRepository;
import tur.tkey.CargoManager.repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DefaultUserService implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public boolean validateEmail(String email){
        return true;
                //todo
    }

    @Override
    public void save(User user) {
    userRepository.save(user);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, RoleType roleType) {
    Optional<User> user=userRepository.findByUsername(username);
    if (user.isPresent()) {
    Role role=roleRepository.findByRoleType(roleType.toString());
        user.get().getRoles().add(role);
    }
    throw new UsernameNotFoundException("not found ");//todo
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
