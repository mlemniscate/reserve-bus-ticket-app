package ir.maktabsharif.MK56HW18.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@Getter
@Setter
public class TravelInfo {
    private String initialPoint;
    private String destination;
    private String travelDate;
    private LocalTime travelTime;
}
