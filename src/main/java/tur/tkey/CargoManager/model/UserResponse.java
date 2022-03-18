package tur.tkey.CargoManager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter

@Entity
@Table(name = "user_ResponseToAd")
public class UserResponse {

    @Id
    private Long id;


}
