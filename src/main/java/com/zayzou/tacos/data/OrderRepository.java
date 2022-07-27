package com.zayzou.tacos.data;

import com.zayzou.tacos.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository  extends CrudRepository<OrderRepository,Long> {
//
//    TacoOrder save(TacoOrder order);
//
//    Optional<TacoOrder> findById(Long id);

}