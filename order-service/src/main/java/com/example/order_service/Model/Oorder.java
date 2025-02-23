package com.example.order_service.Model;


import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "oorder")
public class Oorder {

    public Oorder(Integer orderId, Integer orderQuantity) {
        OrderId = orderId;
        OrderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "Oorder{" +
                "OrderId=" + OrderId +
                ", OrderQuantity=" + OrderQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Oorder oorder = (Oorder) o;
        return Objects.equals(OrderId, oorder.OrderId) && Objects.equals(OrderQuantity, oorder.OrderQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OrderId, OrderQuantity);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OrderId;
    private Integer OrderQuantity;

    public Oorder() {

    }
    //private LocalDateTime DataTime;

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer orderId) {
        OrderId = orderId;
    }

    public Integer getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        OrderQuantity = orderQuantity;
    }


}
