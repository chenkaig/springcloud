package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "provider-order",fallback = OrderServiceError.class)
public interface OrderServiceFeign extends OrderService{
}
