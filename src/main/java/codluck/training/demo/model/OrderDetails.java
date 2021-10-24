package codluck.training.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author QuocDA
 * @version 1.1 9/11/2021
 */
@Entity
@Getter
@Setter
public class OrderDetails {
    @Id
    @Column(name = "car_Description")
    private String carDescription;

    @Column(name = "priceFrom")
    private float priceFrom;

    @Column(name = "priceTo")
    private float priceTo;

    @Column(name = "seats")
    private int seats;

    @Column(name = "image")
    private String image;

    @Column(name = "more_Description")
    private String moreDescription;

    @Column(name = "car_Usage")
    private String carUsage;

    @Column(name = "name")
    private String nameUser;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;
}
