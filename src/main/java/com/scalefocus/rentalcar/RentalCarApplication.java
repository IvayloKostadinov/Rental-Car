// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SuppressWarnings("PMD.UseUtilityClass")
@SpringBootApplication
public class RentalCarApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RentalCarApplication.class);


    /**
     * Rental Car main method.
     *
     * @param args - Rental Car - starting from this method
     */


    public static void main(String[] args) {

        LOGGER.warn("Application started");
        SpringApplication.run(RentalCarApplication.class, args);
    }
}
