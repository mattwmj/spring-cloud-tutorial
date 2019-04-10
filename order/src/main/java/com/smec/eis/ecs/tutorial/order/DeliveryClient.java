package com.smec.eis.ecs.tutorial.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "delivery", url = "http://localhost:8083")
public interface DeliveryClient {
    @PostMapping
    Long createDelivery(@RequestBody DeliveryDTO dto);
}
