// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.services;

import com.scalefocus.rentalcar.models.binding.CarBindingModel;
import com.scalefocus.rentalcar.models.binding.StationBindingModel;

import java.util.List;

public interface StationService {

    List<StationBindingModel> getAllStations();

    StationBindingModel getClosestStation(CarBindingModel carBindingModel);
}
