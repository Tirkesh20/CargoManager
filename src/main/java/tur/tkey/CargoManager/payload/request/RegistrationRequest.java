package tur.tkey.CargoManager.payload.request;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@ToString
public class RegistrationRequest {
private String firstName;
private String lastname;
private String email;
private String password;
}
