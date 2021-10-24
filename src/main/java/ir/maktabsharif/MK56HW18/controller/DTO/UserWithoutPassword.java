package ir.maktabsharif.MK56HW18.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserWithoutPassword {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
