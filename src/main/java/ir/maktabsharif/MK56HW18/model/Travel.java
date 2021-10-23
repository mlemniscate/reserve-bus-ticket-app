package ir.maktabsharif.MK56HW18.model;

import ir.maktabsharif.MK56HW18.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Travel.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Travel extends BaseEntity<Long> {
    public static final String TABLE_NAME = "travels";

    @Embedded
    private TravelInformation travelInformation;

}
