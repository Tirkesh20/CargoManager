package tur.tkey.CargoManager.service;

import tur.tkey.CargoManager.model.userModel.Role;
import tur.tkey.CargoManager.model.userModel.RoleType;
import tur.tkey.CargoManager.model.userModel.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void saveRole(Role role);
    void addRoleToUser(String username, RoleType role);
    User getUser(String username);
    List<User> getUser();
}
