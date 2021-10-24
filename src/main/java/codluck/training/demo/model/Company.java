package codluck.training.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "company")
@Data
public class Company {
    @Id
    // Set id tự tăng trong sql
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_Company")
    private String name_Company;

    @Column(name = "logo")
    private String logo;

    @Column(name = "status")
    private boolean status;
}
