package tur.tkey.CargoManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tur.tkey.CargoManager.model.userModel.Role;


public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleType(String role);
}
