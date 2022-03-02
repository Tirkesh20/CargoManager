package tur.tkey.CargoManager.service;

import tur.tkey.CargoManager.model.userModel.Role;
import tur.tkey.CargoManager.model.userModel.RoleType;
import tur.tkey.CargoManager.model.userModel.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String signUpUser(User user);
    Optional<Role> findRoleName(RoleType roleType);
    void enableUser(String email);
    User getUser(String username);
    List<User> getUsers();
}
//todo -> need to add more concrete functions