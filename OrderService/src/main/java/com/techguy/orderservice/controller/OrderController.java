package com.techguy.orderservice.controller;


import com.techguy.orderservice.apiResponse.APIResponse;
import com.techguy.orderservice.dto.orders.OrdersDTO;
import com.techguy.orderservice.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashiq
 * @createdOn 16/03/25 1:38 pm
 * @project AtxEcom
 **/
@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController
{
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<APIResponse> createOrder(@RequestBody OrdersDTO order)
    {
        OrdersDTO orderDto = orderService.createOrder(order);
        APIResponse apiResponse = new APIResponse(orderDto);
        return ResponseEntity.ok(apiResponse);
    }
}
