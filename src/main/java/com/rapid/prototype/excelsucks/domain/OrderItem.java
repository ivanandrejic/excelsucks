package com.rapid.prototype.excelsucks.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_item_food_item",
            joinColumns = {@JoinColumn(name = "order_item_id")},
            inverseJoinColumns = {@JoinColumn(name = "food_item_id")})
    private List<FoodItem> foodItems;

    @Column(name = "name")
    private String name;

    @Column(name = "order_id")
    private Long orderId;
}
