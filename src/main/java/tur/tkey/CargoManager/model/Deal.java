package tur.tkey.CargoManager.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tur.tkey.CargoManager.model.transport.Transport;
import tur.tkey.CargoManager.model.userModel.User;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Entity(name = "deal")
@Table(name = "dael_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Deal {
//todo-> make better logic
    @EmbeddedId
    private DealId dealId;

    @Column(name = "startPoint",nullable = false)
    private String startPoint;
    @Column(name = "endPoint",nullable = false)
    private String endPoint;
    @Column(name = "departureTime",nullable = false)
    private OffsetDateTime departureTime;
    @Column(name = "arrivalTime",nullable = false)
    private  OffsetDateTime arrivalTime;

    private boolean onlinePayment;

    @Column(name = "deal_status",nullable = false)
    private boolean closed;

    @ManyToOne(fetch =FetchType.LAZY)
    @MapsId("transportId")
    private Transport transport;

    @ManyToOne(fetch =FetchType.LAZY)
    @MapsId("customerId")
    private User customer;

    @Column(name = "dealOpenDate",nullable = false)
    private OffsetDateTime dealOpenDate;

    @Column(name = "closeDate",nullable = false)
    private OffsetDateTime closeDate;

    @Column(name = "approved",nullable = false)
    private boolean approved=false;
}
