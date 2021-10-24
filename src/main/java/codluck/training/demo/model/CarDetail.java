package codluck.training.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author QuocDA
 * @version 1.1 9/8/2021
 */
@Entity
@Getter
@Setter
public class CarDetail {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "name_Company")
    private String companyName;

    @Column(name = "image_Path")
    private String imagePath;

    @Column(name = "price_From")
    private float priceFrom;

    @Column(name = "price_To")
    private float priceTo;

    @Column(name = "status_Car")
    private Boolean statusCar;

    @Column(name = "information")
    private String information;

    @Column(name = "color")
    private String color;

    @Column(name = "usage")
    private Boolean usage;

    @Column(name = "type")
    private String type;

    @Column(name = "seats")
    private int seats;

}
