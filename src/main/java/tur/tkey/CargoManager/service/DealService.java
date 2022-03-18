package tur.tkey.CargoManager.service;

import tur.tkey.CargoManager.model.Deal;

import java.util.List;

//todo->make concrete functions
public interface DealService {

     List<Deal> getOpenDeals(Long id);
     List<Deal> getClosedDeals(Long id);
     void ConfirmDeal(Long dealId);
}
