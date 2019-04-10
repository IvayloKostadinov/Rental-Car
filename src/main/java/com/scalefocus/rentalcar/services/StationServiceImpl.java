// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.services;

import com.scalefocus.rentalcar.googleResponse.GoogleResponse;
import com.scalefocus.rentalcar.mappers.CycleAvoidingMappingContext;
import com.scalefocus.rentalcar.mappers.StationMapper;
import com.scalefocus.rentalcar.models.binding.CarBindingModel;
import com.scalefocus.rentalcar.models.binding.StationBindingModel;
import com.scalefocus.rentalcar.repository.StationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    private StationRepository stationRepository;
    private CycleAvoidingMappingContext context;
    private StationMapper mapper;
    private GoogleResponseService googleResponseService;

    /**
     * @param stationRepository     - The repository for the Station entity.
     * @param googleResponseService - The service for the Google response entity.
     */
    @Autowired
    public StationServiceImpl(StationRepository stationRepository, GoogleResponseService googleResponseService) {
        this.stationRepository = stationRepository;
        this.googleResponseService = googleResponseService;
        this.context = new CycleAvoidingMappingContext();
        this.mapper = StationMapper.INSTANCE;
    }


    @Override
    public List<StationBindingModel> getAllStations() {
        List<StationBindingModel> stations = new ArrayList<>();
        stationRepository.findAll().forEach(station -> stations.add(mapper.stationToModel(station, context)));

        return stations;
    }

    @Override
    public StationBindingModel getClosestStation(CarBindingModel carBindingModel) {

        List<StationBindingModel> stations = getAllStations();
        Double route = Double.MAX_VALUE;
        StationBindingModel stationBindingModel = new StationBindingModel();


        for (StationBindingModel station : stations) {
            GoogleResponse googleResponse =
                    googleResponseService.getRouteAttributes(
                            carBindingModel.getLocationAddress().trim().replaceAll("\\s+", ""),
                            station.getLocationAddress().trim().trim().replaceAll("\\s+", ""));

            Double distance = googleResponse
                    .getRoutes().get(0).getLegs().get(0).getDistance().getValue() / 1000.0;

            if (route > distance) {
                route = distance;
                stationBindingModel = station;
            }

        }

        return stationBindingModel;
    }

}
