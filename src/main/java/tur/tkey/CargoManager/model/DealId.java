package tur.tkey.CargoManager.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class DealId implements Serializable {

    @Column(name = "transport_id")
    private Long transportId;

    @Column(name = "customer_id")
    private Long customerId;

}
