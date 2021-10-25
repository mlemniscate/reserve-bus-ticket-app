package ir.maktabsharif.MK56HW18.model;

import ir.maktabsharif.MK56HW18.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = Ticket.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket extends BaseEntity<Long> {
    public static final String TABLE_NAME = "tickets";
    public static final String OWNER_NAME = "owner_name";
    public static final String GENDER = "gender";

    @Column(name = OWNER_NAME, nullable = false)
    private String ownerName;
    @Column(name = GENDER, nullable = false)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;


}
