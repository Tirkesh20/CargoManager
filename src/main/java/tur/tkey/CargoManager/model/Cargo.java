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
    private float height;
    private float weight;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "transport_id",nullable = false)
    private Transport transport;
}
