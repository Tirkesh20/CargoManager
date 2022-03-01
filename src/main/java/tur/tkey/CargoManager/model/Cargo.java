package tur.tkey.CargoManager.model;


import lombok.Getter;
import lombok.Setter;
import tur.tkey.CargoManager.model.transport.Transport;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float height;
    private float weight;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "transport_id",nullable = false)
    private Transport transport;

    private boolean delivered;
}
