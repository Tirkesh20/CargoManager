package tur.tkey.CargoManager.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tur.tkey.CargoManager.model.Cargo;
import tur.tkey.CargoManager.model.SearchRequest;
import tur.tkey.CargoManager.model.transport.Transport;

import java.util.List;

@Service
@Slf4j
@Transactional
public class DefaultTransportService implements TransportService {

    @Override
    public List<Transport> searchTransPort(SearchRequest searchRequest) {
        //todo
        return null;
    }

    @Override
    public List<Cargo> retrieveTransportCargos(Long id) {
        //todo
        return null;
    }
}
