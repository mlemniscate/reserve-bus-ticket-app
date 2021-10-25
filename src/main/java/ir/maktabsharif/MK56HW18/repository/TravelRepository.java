package ir.maktabsharif.MK56HW18.repository;

import ir.maktabsharif.MK56HW18.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
    List<Travel> findAllByTravelInformation_InitialPointAndTravelInformation_DestinationAndTravelInformation_TravelDate(String initial, String destination, String date);
}
