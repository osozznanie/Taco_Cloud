package com.example.tacocloud.domain;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("taco_orders")
public class TacoOrder {
    @PrimaryKey
    private UUID id = Uuids.timeBased();

    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Invalid credit card number")
    private String ccNumber;

    private String ccExpiration;

    @Size(min = 3, max = 3, message = "CVV must be exactly 3 digits")
    private String ccCVV;

    @Column("tacos")
    private List<TacoUDT> tacos = new ArrayList<>();

    private Date createdAt = new Date();


    public void addTaco(TacoUDT taco) {
        this.tacos.add(taco);
    }

    public Date getPlacedAt() {
        return createdAt;
    }

    public void setPlacedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
