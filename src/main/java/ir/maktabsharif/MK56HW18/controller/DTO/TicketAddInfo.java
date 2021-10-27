package ir.maktabsharif.MK56HW18.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TicketAddInfo {
    private Long travelId;
    private String username;
    private String ownerName;
    private String gender;
}
