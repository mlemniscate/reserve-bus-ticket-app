package ir.maktabsharif.MK56HW18.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
public class TravelInformation {

    public static final String INITIAL_POINT = "initial_point";
    public static final String DESTINATION = "destination";
    public static final String TRAVEL_DATE = "travel_date";
    public static final String TRAVEL_TIME = "travel_time";

    @Column(name = INITIAL_POINT, nullable = false)
    private String initialPoint;
    @Column(name = DESTINATION, nullable = false)
    private String destination;
    @Column(name = TRAVEL_DATE, nullable = false)
    private LocalDate travelDate;
    @Column(name = TRAVEL_TIME, nullable = false)
    private LocalTime travelTime;

}
