// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.controllers;

import com.scalefocus.rentalcar.services.CarService;
import com.scalefocus.rentalcar.services.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

    private CarService carService;
    private RouteService routeService;

    /**
     *
     * @param carService - The service class for the Car entity.
     * @param routeService - The service class for the Route entity.
     */

    @Autowired
    public CarController(CarService carService, RouteService routeService) {
        this.carService = carService;
        this.routeService = routeService;
    }

    /**
     *
     * @param model - Model and View for the page.
     * @return - returns the view for all cars.
     */


    @RequestMapping("/cars")
    public ModelAndView getAllCars(ModelAndView model) {
        model.addObject("cars", carService.getAllCars());
        model.setViewName("cars");
        return model;
    }



}
