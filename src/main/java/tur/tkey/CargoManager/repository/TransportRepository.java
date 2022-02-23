package tur.tkey.CargoManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tur.tkey.CargoManager.model.transport.Transport;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly=true)
public interface TransportRepository  extends JpaRepository<Transport,Long> {

  Optional<Transport> findTransportByStartPoint(String startPoint);

}
