package com.example.order_service.Controller;


import com.example.order_service.DTO.CreateOrderRequest;
import com.example.order_service.Model.Order;
import com.example.order_service.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("save-order")
    public ResponseEntity<Order> SaveOrder(@RequestBody CreateOrderRequest createOrderRequest){
        Order order = orderService.createOrder(
                createOrderRequest.getCustomerId(),
                createOrderRequest.getOrderItems(),
                createOrderRequest.getShippingAddress()
        );
        return ResponseEntity.ok(order);
    }
}
