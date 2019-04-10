// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.controllers;

import com.scalefocus.rentalcar.services.StationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StationController {

    private StationService stationService;


    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    /**
     * @param model - Model and View for the page.
     * @return - returns redirected view to all stations.
     */

    @RequestMapping("/stations")
    public ModelAndView getAllStations(ModelAndView model) {
        model.addObject("stations", stationService.getAllStations());
        model.setViewName("/stations");

        return model;
    }
}
