// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.mappers;


import com.scalefocus.rentalcar.domain.Car;
import com.scalefocus.rentalcar.models.binding.CarBindingModel;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Car modelToCar(CarBindingModel model, @Context CycleAvoidingMappingContext context);

    CarBindingModel carToModel(Car car, @Context CycleAvoidingMappingContext context);
}
