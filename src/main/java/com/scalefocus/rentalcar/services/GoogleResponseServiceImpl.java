// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.services;

import com.scalefocus.rentalcar.googleResponse.GoogleResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;


@Service
public class GoogleResponseServiceImpl implements GoogleResponseService {
    @Override
    public GoogleResponse getRouteAttributes(String startLocation, String endLocation) {
        final String key = "AIzaSyBgLWqMVcQfF3Qk1fINGya7Bu9GwPEwnOs";
        String myUrl = "https://maps.googleapis.com/maps/api/directions/json?origin="
                + startLocation + "&destination="
                + endLocation + "&key=" + key;

        UriTemplate uriTemplate = new UriTemplate(myUrl);

        RestTemplate restTemplate = new RestTemplate();
        GoogleResponse googleResponse = restTemplate.getForObject(myUrl, GoogleResponse.class);

        return googleResponse;
    }


}
