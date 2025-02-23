package com.example.order_service.DTO;

import com.example.order_service.Model.Address;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public class CreateOrderRequest {

    @NotNull(message = "Customer ID cannot be null")
    private UUID customerId;

    @NotEmpty(message = "Order items cannot be empty")
    @Valid  // Validate each OrderItemRequest in the list
    private List<OrderItemRequest> orderItems;

    @NotNull(message = "Shipping address cannot be null")
    @Valid  // Validate the Address object
    private Address shippingAddress;

    public CreateOrderRequest(UUID customerId, List<OrderItemRequest> orderItems, Address shippingAddress) {
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.shippingAddress = shippingAddress;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public @NotEmpty(message = "Order items cannot be empty") @Valid List<OrderItemRequest> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemRequest> orderItems) {
        this.orderItems = orderItems;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}