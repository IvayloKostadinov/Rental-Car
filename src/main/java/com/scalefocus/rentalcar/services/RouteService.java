// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.services;


import com.scalefocus.rentalcar.domain.Route;
import com.scalefocus.rentalcar.models.binding.CarBindingModel;

public interface RouteService {

    Boolean checkRoute(Route route, CarBindingModel carBindingModel);


}
