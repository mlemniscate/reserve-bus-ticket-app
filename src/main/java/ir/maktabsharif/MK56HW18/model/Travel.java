package ir.maktabsharif.MK56HW18.model;

import ir.maktabsharif.MK56HW18.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
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

    @Embedded
    private TravelInformation travelInformation;

    @OneToMany
    @JoinColumn(name = "travel_id")
    private List<Ticket> tickets = new ArrayList<>();

}
