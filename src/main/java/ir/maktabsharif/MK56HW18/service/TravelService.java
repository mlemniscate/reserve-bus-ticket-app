package ir.maktabsharif.MK56HW18.service;

import ir.maktabsharif.MK56HW18.model.Travel;

import java.util.List;

public interface TravelService {
    List<Travel> getTravelsByInfo(String initial, String destination, String date);
}
