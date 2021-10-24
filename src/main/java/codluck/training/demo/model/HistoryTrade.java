package codluck.training.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "historytrade")
@Data
public class HistoryTrade {
    @Id
    // Set id tự tăng trong sql
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_Id")
    private int userID;

    @Column(name = "car_Id")
    private int carID;

    @Column(name = "user_Id_Partner")
    private int userIDParter;

    @Column(name = "money")
    private float money;

    @Column(name = "status")
    private boolean status;

    @Column(name = "date")
    private String date;

    public HistoryTrade(){

    }

    public HistoryTrade(int userId,int userIDParter, int carId, float money, String date, boolean status) {
        this.userID = userId;
        this.carID = carId;
        this.money = money;
        this.date=date;
        this.status=status;
        this.userIDParter=userIDParter;
    }
}
