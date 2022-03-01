package tur.tkey.CargoManager.service;

import tur.tkey.CargoManager.model.Cargo;
import tur.tkey.CargoManager.model.SearchRequest;
import tur.tkey.CargoManager.model.transport.Transport;

import java.util.List;
import java.util.Optional;

public interface TransportService {
   List<Transport> searchTransPort(SearchRequest searchRequest);
    List<Cargo> retrieveTransportCargos(Long id);

}
