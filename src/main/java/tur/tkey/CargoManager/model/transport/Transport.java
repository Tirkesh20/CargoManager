package tur.tkey.CargoManager.model.transport;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import tur.tkey.CargoManager.model.userModel.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Table(name = "transport")
@Entity
@Getter
@Setter
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TransportType transportType;
    @Column(name = "rating") @Min(1) @Max(10)
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Transport transport = (Transport) o;
        return id != null && Objects.equals(id, transport.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", transportType=" + transportType +
                '}';
    }
}
