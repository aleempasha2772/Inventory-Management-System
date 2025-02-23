package com.example.order_service.Controller;


import com.example.order_service.Model.Oorder;
import com.example.order_service.Service.OorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OorderController {

    @Autowired
    private OorderService oorderService;


    @PostMapping("order")
    public ResponseEntity<Oorder> SaveOrder(@RequestBody Oorder order){
        System.out.println(order.getOrderQuantity()+"Order Quantity");
        oorderService.SaveOrder(order);
        return ResponseEntity.ok(order);
    }
}
