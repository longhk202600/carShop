package codluck.training.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author QuocDA
 * @version 1.1 9/6/2021
 */
@Entity
@Table(name = "postorder")
@Getter
@Setter
public class PostOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_Id")
    private int idUser;

    @Column(name = "price_From")
    private int priceFrom;

    @Column(name = "price_To")
    private int priceTo;

    @Column(name = "seats")
    private int seats;

    @Column(name = "image")
    private String image;

    @Column(name = "more_Description")
    private String moreDescription;

    @Column(name = "car_Description")
    private String carDescription;

    @Column(name = "car_Usage")
    private boolean carUsage;

    @Column(name = "status")
    private boolean status;

    public PostOrder() {
        this.status = true;
    }
}
