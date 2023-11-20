package com.example.tacocloud.repository;

import com.example.tacocloud.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.rmi.server.UID;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, UID> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

    List<TacoOrder> findByDeliveryCityOrderByDeliveryTo(String city);
}

