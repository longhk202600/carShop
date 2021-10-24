package codluck.training.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author QuocDA
 * @version 1.1 9/6/2021
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "car_Id")
    private int carId;

    @Column(name = "user_Id")
    private int userId;

    @Column(name = "status")
    private boolean status;

    public Order() {
    }

    public Order(int id, int user_id,boolean status) {
        this.carId = id;
        this.userId = user_id;
        this.status = status;
    }

    public Order(int id, int userId, int carId, boolean status) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.status = status;
    }
}
