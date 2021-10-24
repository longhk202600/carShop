package codluck.training.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "car")
@Data
public class Car {
    @Id
    // Set id tự tăng trong sql
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_Id")
    private int userId;

    @Column(name = "`name`")
    private String name;

    @Column(name = "company_Id")
    private int companyId;

    @Column(name = "image_Path")
    private String imagepath;

    @Column(name = "price_From")
    private int priceFrom;

    @Column(name = "price_To")
    private int priceTo;

    @Column(name = "information")
    private String information;

    @Column(name = "status_Car")
    private Boolean statusCar;

    @Column(name = "phone")
    private String phone;

    @Column(name = "color")
    private String color;

    @Column(name = "usage")
    private Boolean usage;

    @Column(name = "type")
    private String type;

    @Column(name = "seats")
    private int seats;

    @Column(name = "status")
    private boolean status;

    public Car() {
        this.statusCar = true;
        this.status = true;
    }


}

