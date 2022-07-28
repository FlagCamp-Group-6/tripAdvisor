package com.flagcamp.tripadvisor.controller;

import com.flagcamp.tripadvisor.model.PointOfInterest;
import com.flagcamp.tripadvisor.service.PointOfInterestService;
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

    @GetMapping(value = "/pointofinterest/{Id}")
    public PointOfInterest getStay(@PathVariable Long Id) {
        return pointOfInterestService.findByCurId(Id);
    }

    @PostMapping("/pointofinterest")
    public void addPointOfInterest(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("description") String description
            ) {

        PointOfInterest pointOfInterest = new PointOfInterest.Builder()
                .setName(name)
                .setAddress(address)
                .setDescription(description)
                .build();
        pointOfInterestService.add(pointOfInterest);
    }

    @DeleteMapping("/pointofinterest/{Id}")
    public void deletePointOfInterest(@PathVariable Long Id) {
        pointOfInterestService.delete(Id);
    }


}
