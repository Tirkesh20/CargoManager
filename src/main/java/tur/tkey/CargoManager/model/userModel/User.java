package tur.tkey.CargoManager.model.userModel;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    private String name;
    private String email;
    private String password;
    private AppUserRole userRole;


}
