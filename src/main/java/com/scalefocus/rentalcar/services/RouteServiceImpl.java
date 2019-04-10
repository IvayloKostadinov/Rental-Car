// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.services;


import com.scalefocus.rentalcar.domain.Route;
import com.scalefocus.rentalcar.googleResponse.GoogleResponse;
import com.scalefocus.rentalcar.mappers.CarMapper;
import com.scalefocus.rentalcar.mappers.CycleAvoidingMappingContext;
import com.scalefocus.rentalcar.models.binding.CarBindingModel;
import com.scalefocus.rentalcar.models.binding.StationBindingModel;
import com.scalefocus.rentalcar.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;


@Service
public class RouteServiceImpl implements RouteService {

    private CarRepository carRepository;
    private CarService carService;
    private CycleAvoidingMappingContext context;
    private CarMapper mapper;
    private StationService stationService;
    private GoogleResponseService googleResponseService;
    private static DecimalFormat df2 = new DecimalFormat(".##");

    /**
     * @param carRepository         - The repository for the Car entity.
     * @param carService            - The service for the Car entity.
     * @param stationService        - The service for the Station entity.
     * @param googleResponseService - The service for the Google response entity.
     */


    @Autowired
    public RouteServiceImpl(CarRepository carRepository, CarService carService,
                            StationService stationService,
                            GoogleResponseService googleResponseService) {
        this.carRepository = carRepository;
        this.carService = carService;
        this.googleResponseService = googleResponseService;
        this.stationService = stationService;
        this.context = new CycleAvoidingMappingContext();
        this.mapper = CarMapper.INSTANCE;
    }

    /**
     * @param route           - start and end locations.
     * @param carBindingModel - Binding model for Car Entity.
     * @return - if root is available.
     */


    @Override
    public Boolean checkRoute(Route route, CarBindingModel carBindingModel) {
        boolean readyToGo = false;

        GoogleResponse googleResponse =
                googleResponseService.getRouteAttributes(
                        route.getStartLocation()
                                .trim().replaceAll("\\s+", ""),
                        route.getEndLocation()
                                .trim().replaceAll("\\s+", ""));

        Double distance = googleResponse
                .getRoutes().get(0).getLegs().get(0).getDistance().getValue() / 1000.0;

        if (carBindingModel.getCharge() - distance < 10) {

            StationBindingModel stationBindingModel = stationService.getClosestStation(carBindingModel);

            carBindingModel.setLongitude(stationBindingModel.getLongitude());
            carBindingModel.setLatitude(stationBindingModel.getLatitude());
            carBindingModel.setLocationAddress(stationBindingModel.getLocationAddress());
            carBindingModel.setCharge(100D);
            carService.update(carBindingModel);

        } else {
            setCarAttributes(carBindingModel, googleResponse, distance);

            readyToGo = true;
        }


        return readyToGo;
    }

    private void setCarAttributes(CarBindingModel carBindingModel,
                                  GoogleResponse googleResponse, Double distance) {
        String endLatitude = String.valueOf(googleResponse.getRoutes().get(0).getLegs()
                .get(0).getEnd_location().getLat());
        String endLongitude = String.valueOf(googleResponse.getRoutes().get(0).getLegs()
                .get(0).getEnd_location().getLng());
        String address = googleResponse.getRoutes().get(0).getLegs()
                .get(0).getEnd_address();


        carBindingModel.setCharge(Double.valueOf(df2
                .format(carBindingModel.getCharge() - distance)));
        carBindingModel.setLatitude(endLatitude);
        carBindingModel.setLongitude(endLongitude);
        carBindingModel.setLocationAddress(address);

        carService.update(carBindingModel);
    }


}
