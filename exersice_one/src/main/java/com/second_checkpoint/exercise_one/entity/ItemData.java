package com.second_checkpoint.exercise_one.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "ITEM")
public class ItemData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String sku;
    private String name;
    private Double price;
    private String description;
    private String thumbnail;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "currency_id")
    private CurrencyData currency;
    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "item_id")
    private List<ImageData> images;
}