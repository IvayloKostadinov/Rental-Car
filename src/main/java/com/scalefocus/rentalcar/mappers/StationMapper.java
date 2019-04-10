// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.mappers;

import com.scalefocus.rentalcar.domain.Station;
import com.scalefocus.rentalcar.models.binding.StationBindingModel;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StationMapper {

    StationMapper INSTANCE = Mappers.getMapper(StationMapper.class);

    Station modelToStation(StationBindingModel model, @Context CycleAvoidingMappingContext context);

    StationBindingModel stationToModel(Station station, @Context CycleAvoidingMappingContext context);
}
