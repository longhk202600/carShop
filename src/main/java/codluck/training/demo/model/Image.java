package codluck.training.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "image")
@Data
public class Image {

    @Id
    // Set id tự tăng trong sql
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_Id")
    private int carId;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    private boolean status;

    public Image (){
        this.status= true;
    }
}
