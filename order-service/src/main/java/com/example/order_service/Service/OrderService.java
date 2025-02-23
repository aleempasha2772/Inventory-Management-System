package com.example.order_service.Service;

import com.example.order_service.DTO.OrderItemRequest;
import com.example.order_service.Model.Address;
import com.example.order_service.Model.Order;
import com.example.order_service.Model.OrderItem;
import com.example.order_service.Model.OrderStatus;
import com.example.order_service.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Order createOrder(UUID customerId, List<OrderItemRequest> orderItemRequests, Address shippingAddress) {
        Order order = new Order();
        order.setOrderId(UUID.randomUUID()); // Generate the ID!
        order.setCustomerId(customerId);
        order.setOrderDate(OffsetDateTime.now());
        order.setShippingAddress(shippingAddress);
        //Map OrderItemRequest to OrderItem
        List<OrderItem> orderItems = orderItemRequests.stream()
                .map(orderItemRequest -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProductId(orderItemRequest.getProductId());
                    orderItem.setQuantity(orderItemRequest.getQuantity());
                    // You'll need to fetch the product details (name, price) from the database
                    // or from another service based on the productId.
                    // For now, I'm leaving it as placeholders, but you need to implement this.
                    // Example (you'll need a ProductRepository or ProductService):
                    // Product product = productRepository.findById(orderItemRequest.getProductId())
                    //        .orElseThrow(() -> new ProductNotFoundException("Product not found"));
                    orderItem.setProductName("Product Name Placeholder"); // replace with product.getName()
                    orderItem.setUnitPrice(BigDecimal.TEN); // replace with product.getPrice()
                    orderItem.setOrder(order);
                    return orderItem;
                })
                .collect(Collectors.toList());

        order.setOrderItems(orderItems);
        order.calculateTotalAmount(); // Calculate the total
        order.setOrderStatus(OrderStatus.PENDING);

        // Persist the order
        Order savedOrder = orderRepository.save(order);

        // Publish an OrderCreated event to Pulsar

        return savedOrder;
    }

    public List<Order> GetAllOrders() {
        if(orderRepository.count() != 0) {
            return orderRepository.findAll();
        }
        return null;
    }
}
