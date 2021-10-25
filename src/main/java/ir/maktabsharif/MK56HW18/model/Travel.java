package ir.maktabsharif.MK56HW18.model;

import ir.maktabsharif.MK56HW18.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Travel.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Travel extends BaseEntity<Long> {
    public static final String TABLE_NAME = "travels";
    public static final String INITIAL_POINT = "initial_point";
    public static final String DESTINATION = "destination";
    public static final String TRAVEL_DATE = "travel_date";
    public static final String TRAVEL_TIME = "travel_time";

    @Column(name = INITIAL_POINT, nullable = false)
    private String initialPoint;
    @Column(name = DESTINATION, nullable = false)
    private String destination;
    @Column(name = TRAVEL_DATE, nullable = false)
    private String travelDate;
    @Column(name = TRAVEL_TIME, nullable = false)
    private LocalTime travelTime;

    @OneToMany
    @JoinColumn(name = "travel_id")
    private List<Ticket> tickets = new ArrayList<>();

}
