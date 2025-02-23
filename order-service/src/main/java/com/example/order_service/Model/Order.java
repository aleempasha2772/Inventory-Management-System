package com.example.order_service.Model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)  // Generate UUIDs automatically
    @Column(name = "order_id", columnDefinition = "uuid")
    private UUID orderId;

    @Column(name = "customer_id", nullable = false, columnDefinition = "uuid")
    private UUID customerId;

    @Column(name = "order_date", nullable = false)
    private OffsetDateTime orderDate;

    @Embedded  // Embed the Address value object
    private Address shippingAddress;

    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)  // Store the enum as a string in the database
    private OrderStatus orderStatus;

    @Column(name = "total_amount", nullable = false, precision = 19, scale = 2) // Adjust precision/scale as needed
    private BigDecimal totalAmount;

    @Embedded // Embed the PaymentInfo value object
    private PaymentInfo paymentInfo;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    // This establishes the one-to-many relationship with OrderItem
    // `mappedBy` indicates the owning side of the relationship (Order is the owner)
    // `cascade = CascadeType.ALL` means that all operations (persist, merge, remove) on Order are cascaded to OrderItem
    // `orphanRemoval = true` means that if an OrderItem is removed from the Order's `orderItems` collection, it is also removed from the database.
    //  `fetch = FetchType.EAGER` loads the order items at the same time as loading the order. Adjust if performance becomes an issue with large orders.
    private List<OrderItem> orderItems;

    public Order() {

    }

    // Methods (as described in the previous response)
    public void addItem(Product product, int quantity) {
        // Implementation (add logic and update totalAmount)
    }

    public void removeItem(UUID productId) {
        // Implementation
    }

    public void setShippingAddress(Address address) {
        this.shippingAddress = address;
    }

    public void cancelOrder() {
        this.orderStatus = OrderStatus.CANCELLED;
    }

    public void markAsShipped() {
        this.orderStatus = OrderStatus.SHIPPED;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void calculateTotalAmount() {
        // Implementation (calculate totalAmount based on orderItems)
    }

    public void validateOrder() {
        // Implementation (validation logic)
    }

    public Order(UUID orderId, UUID customerId, OffsetDateTime orderDate, Address shippingAddress, OrderStatus orderStatus, BigDecimal totalAmount, PaymentInfo paymentInfo, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.paymentInfo = paymentInfo;
        this.orderItems = orderItems;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public OffsetDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}