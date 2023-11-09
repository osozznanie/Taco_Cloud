package com.example.tacocloud.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
// This annotation is required because the table name is different from the class name
@Entity
@Table("taco_cloud_orders")
public class TacoOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column("delivery_name")
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @Column("delivery_street")
    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @Column("delivery_city")
    @NotBlank(message = "City is required")
    private String deliveryCity;

    @Column("delivery_state")
    @NotBlank(message = "State is required")
    private String deliveryState;

    @Column("delivery_zip")
    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @Column("cc_number")
    @CreditCardNumber(message = "Invalid credit card number")
    private String ccNumber;

    @Column("cc_expiration")
    private String ccExpiration;

    @Column("cc_cvv")
    @Size(min = 3, max = 3, message = "CVV must be exactly 3 digits")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();
    private Date createdAt;


    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

    public Date getPlacedAt() {
        return createdAt;
    }

    public void setPlacedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
