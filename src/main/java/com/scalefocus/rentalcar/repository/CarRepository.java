// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.repository;

import com.scalefocus.rentalcar.domain.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
