// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.controllers;

import com.scalefocus.rentalcar.domain.Route;
import com.scalefocus.rentalcar.models.binding.CarBindingModel;
import com.scalefocus.rentalcar.services.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteController {
    private RouteService routeService;


    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    /**
     *
     * @param route - Start and End locations.
     * @param carBindingModel - The Binding Model for the Car
     * @param model - Model and View for the page.
     * @return - returns redirected view to all cars.
     */

    @PostMapping("/cars/book")
    public ModelAndView getRoute(@ModelAttribute Route route,
                                 @ModelAttribute CarBindingModel carBindingModel, ModelAndView model) {

        routeService.checkRoute(route,carBindingModel);
        model.setViewName("redirect:/cars");

        return model;
    }

    /**
     *
     * @param model - Model and View for the page.
     * @return - returns the view for about page.
     */

    @RequestMapping("/about")
    public ModelAndView getAboutPage(ModelAndView model) {
        model.setViewName("about");
        return model;
    }

    /**
     *
     * @param model - Model and View for the page.
     * @return - returns the view for contact page.
     */


    @RequestMapping("/contact")
    public ModelAndView getContact(ModelAndView model) {
        model.setViewName("contact");
        return model;
    }

    /**
     *
     * @param model - Model and View for the page.
     * @return - returns the view for home page.
     */


    @RequestMapping("/home")
    public ModelAndView getHomePage(ModelAndView model) {
        model.setViewName("index");
        return model;
    }
}
