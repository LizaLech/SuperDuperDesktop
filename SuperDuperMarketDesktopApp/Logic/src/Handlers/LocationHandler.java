package Handlers;

import Models.SDMLocation;

import static java.lang.Math.sqrt;

public class LocationHandler {

    public double calculateDistanceOfTwoLocations(SDMLocation loc1, SDMLocation loc2){
        return sqrt((loc2.y - loc2.x) * (loc2.y - loc2.x) + (loc1.y - loc1.x) * (loc1.y  - loc1.x));
    }

    public double calculateDeliveryCost(SDMLocation loc1, SDMLocation loc2, int ppk){
        return ppk * calculateDistanceOfTwoLocations(loc1, loc2);
    }
}
