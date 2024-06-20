package com.example.judoStore.persistence.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ordersId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productsId")
    private Product product;

    private Long quantity;
}
