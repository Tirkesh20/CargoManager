package tur.tkey.CargoManager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
//todo
public class SearchRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public SearchRequest(String startPoint, String endPoint, OffsetDateTime tookOfTime, boolean onlinePayment) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.tookOfTime = tookOfTime;
        this.onlinePayment = onlinePayment;
    }

    private String startPoint;
    private String endPoint;
    @Transient
    private OffsetDateTime tookOfTime;
    @Transient
    private boolean onlinePayment;

}
