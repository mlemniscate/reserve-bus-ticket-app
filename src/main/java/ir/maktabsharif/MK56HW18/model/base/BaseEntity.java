package ir.maktabsharif.MK56HW18.model.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity<ID extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ID id;
}
