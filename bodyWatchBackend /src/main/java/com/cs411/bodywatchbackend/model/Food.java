package com.cs411.bodywatchbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Foods")
@Getter
@Setter
public class Food {

    @Id
    @Column(name = "FoodId", nullable = false)
    private int foodId;

    @Column(name = "ProdName", length = 255, nullable = false)
    private String prodName;

    @Column(name = "GenericName", length = 255, nullable = false)
    private String genericName;

    @Column(name = "Quantity", length = 255, nullable = false)
    private String quantity;

    @Column(name = "IngredientsText", length = 255, nullable = false)
    private String ingredientsText;

    @Column(name = "ServSize", length = 255, nullable = false)
    private String servSize;

    @Column(name = "ukGrade", length = 50, nullable = false)
    private String ukGrade;

    @Column(name = "frGrade", length = 50, nullable = false)
    private String frGrade;

    @Column(name = "ImageURL", length = 255, nullable = false)
    private String imageURL;

    @Column(name = "Energy100g", precision = 8, scale = 2, nullable = false)
    private BigDecimal energy100g;

    @Column(name = "EnergyFat100g", precision = 8, scale = 2, nullable = false)
    private BigDecimal energyFat100g;

}
