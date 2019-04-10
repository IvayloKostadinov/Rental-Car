// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.repository;

import com.scalefocus.rentalcar.domain.Station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
}
