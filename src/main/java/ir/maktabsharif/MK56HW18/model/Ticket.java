package ir.maktabsharif.MK56HW18.model;

import ir.maktabsharif.MK56HW18.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Ticket.TABLE_NAME)
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
    @Embedded
    private TravelInformation travelInformation;


}
