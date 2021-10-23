package ir.maktabsharif.MK56HW18.model;

import ir.maktabsharif.MK56HW18.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = Ticket.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket extends BaseEntity<Long> {
    public static final String TABLE_NAME = "tickets";
    public static final String OWNER_NAME = "owner_name";
    public static final String GENDER = "gender";
    public static final String INITIAL_POINT = "initial_point";
    public static final String DESTINATION = "destination";
    public static final String TRAVEL_DATE = "travel_date";
    public static final String TRAVEL_TIME = "travel_time";

    @Column(name = OWNER_NAME, nullable = false)
    private String ownerName;
    @Column(name = GENDER, nullable = false)
    private String gender;
    @Column(name = INITIAL_POINT, nullable = false)
    private String initialPoint;
    @Column(name = DESTINATION, nullable = false)
    private String destination;
    @Column(name = TRAVEL_DATE, nullable = false)
    private LocalDate travelDate;
    @Column(name = TRAVEL_TIME, nullable = false)
    private LocalTime travelTime;


}
