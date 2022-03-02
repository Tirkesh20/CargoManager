package tur.tkey.CargoManager.model.userModel;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "roleType")
    private RoleType roleType;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private List<User> users;

}
