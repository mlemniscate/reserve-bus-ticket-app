package ir.maktabsharif.MK56HW18.controller;

import ir.maktabsharif.MK56HW18.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {

    private TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

}
