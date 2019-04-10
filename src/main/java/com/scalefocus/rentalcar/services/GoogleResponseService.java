// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.services;

import com.scalefocus.rentalcar.googleResponse.GoogleResponse;

public interface GoogleResponseService {

    GoogleResponse getRouteAttributes(String startLocation, String endLocation);
}
