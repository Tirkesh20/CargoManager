package tur.tkey.CargoManager.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tur.tkey.CargoManager.security.AppUser;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository {
    Optional<AppUser> findByEmail(String email);
}
