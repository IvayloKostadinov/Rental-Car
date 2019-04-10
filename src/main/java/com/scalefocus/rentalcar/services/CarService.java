// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.services;


import com.scalefocus.rentalcar.domain.Car;
import com.scalefocus.rentalcar.models.binding.CarBindingModel;

import java.util.List;

public interface CarService {

    CarBindingModel findById(Long id);

    List<CarBindingModel> getAllCars();

    Car update(CarBindingModel car);

}
