package com.zayzou.tacos.data;

import com.zayzou.tacos.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository  extends CrudRepository<TacoOrder,String> {
//
//    TacoOrder save(TacoOrder order);
//
//    Optional<TacoOrder> findById(Long id);
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
    List<TacoOrder> findByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate,Date endDate);
    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate,Date endDate);
    int countOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate,Date endDate);
    List<TacoOrder> getByDeliveryCityIgnoreCase(String deliveryCity);


}