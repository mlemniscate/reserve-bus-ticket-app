package ir.maktabsharif.MK56HW18.controller;

import ir.maktabsharif.MK56HW18.controller.DTO.TravelInfo;
import ir.maktabsharif.MK56HW18.model.Travel;
import ir.maktabsharif.MK56HW18.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TravelController {

    private TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("travel/search")
    @CrossOrigin
    public List<TravelInfo> findTravelsByInfo(@RequestParam String initial, String destination, String date) {
        List<Travel> travelsByInfo = travelService.getTravelsByInfo(initial, destination, date);
        List<TravelInfo> travelInfoList = new ArrayList<>();
        travelsByInfo.forEach(item -> {
            travelInfoList.add(new TravelInfo(
                    item.getTravelInformation().getInitialPoint(),
                    item.getTravelInformation().getDestination(),
                    item.getTravelInformation().getTravelDate(),
                    item.getTravelInformation().getTravelTime()
            ));
        });
        return travelInfoList;
    }

}
