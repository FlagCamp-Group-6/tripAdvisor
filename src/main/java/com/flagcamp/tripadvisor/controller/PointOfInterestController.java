package com.flagcamp.tripadvisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@RestController
public class PointOfInterestController {
    private PointOfInterestService pointOfInterestService;
    @Autowired
    public PointOfInterestController(PointOfInterestService pointOfInterestService) {
        this.pointOfInterestService = pointOfInterestService;
    }

    @PostMapping("/stays")
    public void addPointOfInterest(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("description") String description,
            Principal principal) {

        PointOfInterest pointOfInterest = new PointOfInterest.Builder()
                .setName(name)
                .setAddress(address)
                .setDescription(description)
                .build();
        pointOfInterestService.add(pointOfInterest);
    }

    @DeleteMapping("/stays/{stayId}")
    public void deletePointOfInterest(@PathVariable Long stayId, Principal principal) {
        pointOfInterestService.delete(pointOfInterestId, principal.getName());
    }


}
