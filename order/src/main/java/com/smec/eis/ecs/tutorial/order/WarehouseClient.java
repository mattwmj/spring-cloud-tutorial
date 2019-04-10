package com.smec.eis.ecs.tutorial.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("warehouse")
public interface WarehouseClient {
    @PostMapping
    Long createDelivery(@RequestBody DeliveryDTO dto);
}
