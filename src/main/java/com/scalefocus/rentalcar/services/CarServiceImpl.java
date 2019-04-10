// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.services;

import com.scalefocus.rentalcar.domain.Car;
import com.scalefocus.rentalcar.mappers.CarMapper;
import com.scalefocus.rentalcar.mappers.CycleAvoidingMappingContext;
import com.scalefocus.rentalcar.models.binding.CarBindingModel;
import com.scalefocus.rentalcar.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private CycleAvoidingMappingContext context;
    private CarMapper mapper;

    /**
     *
     * @param carRepository - The repository for the Car entity.
     */


    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.context = new CycleAvoidingMappingContext();
        this.mapper = CarMapper.INSTANCE;
    }

    /**
     *
     * @param id - id of the Car.
     * @return - Returns an object of type CarBindingModel.
     */
    @Override
    public CarBindingModel findById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(car1 -> mapper.carToModel(car1, context)).orElse(null);
    }

    /**
     *
     * @return - Returns all Cars from database.
     */
    @Override
    public List<CarBindingModel> getAllCars() {
        List<CarBindingModel> cars = new ArrayList<>();
        carRepository.findAll().forEach(car -> cars.add(mapper.carToModel(car, context)));

        return cars;
    }

    /**
     *
     * @param carBindingModel - This is already filled binding model
     * @return Returns the updated Car.
     */
    @Override
    public Car update(CarBindingModel carBindingModel) {
        Car car = mapper.modelToCar(carBindingModel, context);

        carRepository.saveAndFlush(car);

        return car;
    }


}
