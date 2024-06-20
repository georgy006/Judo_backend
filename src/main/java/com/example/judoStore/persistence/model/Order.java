package com.example.judoStore.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp ordersDate;
    private BigDecimal totalPrice;
    private Long stockQuantity;
    @ManyToOne
    @JoinColumn(name = "statusId")
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    private List<OrderItem> orderItems;
}
