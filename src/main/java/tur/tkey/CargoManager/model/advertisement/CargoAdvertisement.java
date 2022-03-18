package tur.tkey.CargoManager.model.advertisement;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import tur.tkey.CargoManager.model.transport.Transport;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CargoAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startLocation;
    private String endLocation;


    @OneToMany
    @JoinColumn(name = "transport_id",nullable = false)
    private Transport transport;



    // private List<>//todo
    @CreationTimestamp
    private OffsetDateTime publishDate;
    @UpdateTimestamp
    private OffsetDateTime setOffDate;

    public CargoAdvertisement(String startLocation, String endLocation, Transport transport, OffsetDateTime publishDate, OffsetDateTime setOffDate) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.transport = transport;
        this.publishDate = publishDate;
        this.setOffDate = setOffDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoAdvertisement that = (CargoAdvertisement) o;
        return Objects.equals(id, that.id)
                && Objects.equals(startLocation, that.startLocation)
                && Objects.equals(endLocation, that.endLocation)
                && Objects.equals(transport, that.transport)
                && Objects.equals(publishDate, that.publishDate)
                && Objects.equals(setOffDate, that.setOffDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startLocation, endLocation, transport, publishDate, setOffDate);
    }
}

