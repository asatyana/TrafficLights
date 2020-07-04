package com.ananth.traffic;

import java.util.HashMap;
import java.util.Map;

public class TrafficManager {
    public static final String NORTH = "NORTH";
    public static final String SOUTH = "SOUTH";
    public static final String EAST = "EAST";
    public static final String WEST = "WEST";

    public static void main(String[] args) {
        Traffic northTraffic = new Traffic(NORTH, 7, 8);
        Traffic southTraffic = new Traffic(NORTH, 5, 1);
        Traffic eastTraffic = new Traffic(NORTH, 2, 2);
        Traffic westTraffic = new Traffic(NORTH, 7, 8);
        Map<String, Traffic> traffic = new HashMap<>();
        traffic.put(NORTH, northTraffic);
        traffic.put(SOUTH, southTraffic);
        traffic.put(EAST, eastTraffic);
        traffic.put(WEST, westTraffic);

        TrafficJunction silkBoardJunction = new TrafficJunction(traffic);
        silkBoardJunction.startTrafficManagement();
    }

}
