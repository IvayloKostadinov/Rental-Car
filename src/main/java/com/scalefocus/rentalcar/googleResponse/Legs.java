// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.googleResponse;

public class Legs
    {
        private Distance distance;

        private Duration duration;

        private String end_address;

        private End_location end_location;

        private String start_address;

        private Start_location start_location;

        public void setDistance(Distance distance){
            this.distance = distance;
        }
        public Distance getDistance(){
            return this.distance;
        }
        public void setDuration(Duration duration){
            this.duration = duration;
        }
        public Duration getDuration(){
            return this.duration;
        }
        public void setEnd_address(String end_address){
            this.end_address = end_address;
        }
        public String getEnd_address(){
            return this.end_address;
        }
        public void setEnd_location(End_location end_location){
            this.end_location = end_location;
        }
        public End_location getEnd_location(){
            return this.end_location;
        }
        public void setStart_address(String start_address){
            this.start_address = start_address;
        }
        public String getStart_address(){
            return this.start_address;
        }
        public void setStart_location(Start_location start_location){
            this.start_location = start_location;
        }
        public Start_location getStart_location(){
            return this.start_location;
        }
    }
