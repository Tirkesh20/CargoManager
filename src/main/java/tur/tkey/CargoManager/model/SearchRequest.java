package tur.tkey.CargoManager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@NoArgsConstructor
@Getter
@Setter
public class SearchRequest {
    private String startPoint;
    private String endPoint;
    private OffsetDateTime tookOfTime;
    private boolean onlinePayment;
}
