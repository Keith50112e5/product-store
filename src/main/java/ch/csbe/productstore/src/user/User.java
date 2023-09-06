package ch.csbe.productstore.src.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(columnDefinition = "varchar(255)")
    private String name;
    @Column(columnDefinition = "tinyint")
    private Integer active;
    @Column(columnDefinition = "varchar(255)")
    private String email;
    @Column(columnDefinition = "varchar(255)")
    private String password;
    public void setUser(User user) {
        this.name = user.name;
        this.active = user.active;
        this.email = user.email;
        this.password = user.password;
    }
}
