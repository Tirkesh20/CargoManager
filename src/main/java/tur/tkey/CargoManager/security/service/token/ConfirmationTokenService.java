package tur.tkey.CargoManager.security.service.token;

import java.util.Optional;

public interface ConfirmationTokenService {
    void saveConfirmationToken(ConfirmationToken confirmationToken);
     int setConfirmedAt(String token);
     Optional<ConfirmationToken> getToken(String token);
}
