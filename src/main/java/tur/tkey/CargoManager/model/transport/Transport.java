package tur.tkey.CargoManager.model.transport;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import tur.tkey.CargoManager.model.Cargo;
import tur.tkey.CargoManager.model.userModel.User;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

@Table(name = "transports")
@Entity
@Getter
@Setter
public class Transport {
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String startPoint;
    private String endPoint;
    private OffsetDateTime departureTime;
    private  OffsetDateTime arrivalTime;
    private boolean onlinePayment;
    private boolean closed;
    private TransportType transportType;

    @OneToMany(mappedBy = "transport",fetch = FetchType.LAZY)
    private Set<Cargo> cargos;

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
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", onlinePayment=" + onlinePayment +
                ", closed=" + closed +
                ", transportType=" + transportType +
                ", cargos=" + cargos +
                '}';
    }
}
