package tur.tkey.CargoManager.service;

import tur.tkey.CargoManager.model.userModel.Role;
import tur.tkey.CargoManager.model.userModel.RoleType;
import tur.tkey.CargoManager.model.userModel.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean signUpUser(User user);
    Optional<Role> findRoleName(RoleType roleType);
    void saveRole(Role role);
    void addRoleToUser(String username, RoleType role);
    User getUser(String username);
    List<User> getUser();
}
//todo -> need to add more concrete functions