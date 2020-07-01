package com.ananth.traffic;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class TrafficJunction {
    private final String[] trafficPoles;
    private final List<TrafficLightPole> trafficSystem;

    public TrafficJunction(String[] trafficPoles) {
        this.trafficSystem = new ArrayList<>();
        this.trafficPoles = trafficPoles;
        for (String trafficPole : trafficPoles) {
            this.trafficSystem.add(new TrafficLightPole(trafficPole));
        }
    }

    public void startTraffic() {
        while (true) {
            for (int i = 0; i < trafficPoles.length; i++) {
                if (!this.trafficSystem.get(i).letTrafficGo()) {
                    exit(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] trafficPoles = {"Pole 1", "Pole 2", "Pole 3", "Pole 4"};
        TrafficJunction junction = new TrafficJunction(trafficPoles);
        junction.startTraffic();
    }
}
