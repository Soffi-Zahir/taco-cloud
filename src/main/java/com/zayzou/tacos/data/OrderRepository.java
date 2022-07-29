package com.zayzou.tacos.data;

import com.zayzou.tacos.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository  extends CrudRepository<TacoOrder,String> {
//
//    TacoOrder save(TacoOrder order);
//
//    Optional<TacoOrder> findById(Long id);

}