package tur.tkey.CargoManager.security.service.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tur.tkey.CargoManager.model.userModel.User;

import javax.persistence.*;
import java.time.OffsetDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime expiresAt;

    private OffsetDateTime confirmedAt;


    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public ConfirmationToken(String token, OffsetDateTime createdAt, OffsetDateTime expiresAt,User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user=user;    }
}
