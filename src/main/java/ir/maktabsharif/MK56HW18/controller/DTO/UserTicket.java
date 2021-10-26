package ir.maktabsharif.MK56HW18.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserTicket {
    private Long ticketId;
    private String name;
    private String gender;
    private String initial;
    private String destination;
    private String date;
    private LocalTime time;
    private Long travelId;
}
