package ch.csbe.productstore.src.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(columnDefinition = "varchar(255)")
    private String email;
    @Column(columnDefinition = "varchar(255)")
    private String pw;

    public List<String> getRoles() {
        List<String> hardcodedRoles = new ArrayList<>();
        hardcodedRoles.add("ROLE_ADMIN");
        return hardcodedRoles;
    }
}
