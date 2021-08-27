package com.second_checkpoint.exercise_one.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "CURRENCY")
public class CurrencyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String code;
    private String symbol;
    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "currency_id")
    private List<ItemData> items;
}