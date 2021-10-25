package ir.maktabsharif.MK56HW18.service.impl;

import ir.maktabsharif.MK56HW18.model.Travel;
import ir.maktabsharif.MK56HW18.repository.TravelRepository;
import ir.maktabsharif.MK56HW18.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    private TravelRepository ticketRepository;

    @Autowired
    public TravelServiceImpl(TravelRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Travel> getTravelsByInfo(String initial, String destination, String date) {
        return ticketRepository.findAllByTravelInformation_InitialPointAndTravelInformation_DestinationAndTravelInformation_TravelDate(
                initial,
                destination,
                date
        );
    }
}
