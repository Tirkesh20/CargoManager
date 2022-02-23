package tur.tkey.CargoManager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FilterRequest {
    private String startPoint;
    private String endPoint;
    private Cargo cargo;
    private boolean onlinePayment;
}
