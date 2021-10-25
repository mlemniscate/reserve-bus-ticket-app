package ir.maktabsharif.MK56HW18.model;

import ir.maktabsharif.MK56HW18.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = User.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity<Long> {
    public static final String TABLE_NAME = "users";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";

    @Column(name = USERNAME, nullable = false)
    private String username;
    @Column(name = PASSWORD, nullable = false)
    private String password;
    @Column(name = FIRST_NAME)
    private String firstName;
    @Column(name = LAST_NAME)
    private String lastName;
    @Column(name = EMAIL, nullable = false)
    private String email;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private List<Ticket> tickets = new ArrayList<>();

}
