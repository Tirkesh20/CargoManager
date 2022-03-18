package tur.tkey.CargoManager.model.advertisement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AdminAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //todo->clean and optimize code
    private String from;
    private String to;

    @CreationTimestamp
    private OffsetDateTime publishedTime;
    @UpdateTimestamp
    private OffsetDateTime tillDate;


    public AdminAdvertisement(String from, String to, OffsetDateTime publishedTime, OffsetDateTime tillDate) {
        this.from = from;
        this.to = to;
        this.publishedTime = publishedTime;
        this.tillDate = tillDate;
    }
}
