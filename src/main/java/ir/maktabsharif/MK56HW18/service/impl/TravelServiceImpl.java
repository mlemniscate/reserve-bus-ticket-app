package ir.maktabsharif.MK56HW18.service.impl;

import ir.maktabsharif.MK56HW18.repository.TravelRepository;
import ir.maktabsharif.MK56HW18.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImpl implements TravelService {

    private TravelRepository ticketRepository;

    @Autowired
    public TravelServiceImpl(TravelRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

}
