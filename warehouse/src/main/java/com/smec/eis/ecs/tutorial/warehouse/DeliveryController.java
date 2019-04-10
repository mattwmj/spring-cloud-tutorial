package com.smec.eis.ecs.tutorial.warehouse;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class DeliveryController {

    private final DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @PostMapping
    public Long createDelivery(@RequestBody Delivery dto) {
        Delivery delivery = new Delivery();
        delivery.setAddress(dto.getAddress());
        delivery.setItemName(dto.getItemName());
        delivery.setCreateDate(new Date());
        delivery = deliveryRepository.save(delivery);
        return delivery.getId();
    }

    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

}
