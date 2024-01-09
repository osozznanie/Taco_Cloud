package com.example.tacocloud.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class TacoOrder implements Serializable {
    @Id
    private String id;

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

    private List<Taco> tacos = new ArrayList<>();

    private Date createdAt = new Date();


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
