package com.ananth.traffic;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

/**
 * TrafficJunction implements intersection with 4 roads North, South, East, West.
 */
public class TrafficJunction {
    private final Map<String, Traffic> trafficSystem;

    /**
     * @param trafficSystem List of traffic poles with one pole per road
     */
    public TrafficJunction(Map<String, Traffic> trafficSystem) {
        this.trafficSystem = trafficSystem;
    }

    /**
     * Start traffic management.
     * Default traffic movement is 10 + 10 vehicles in one round if the either queue size is 30
     * If all vehicles pass, signal turns RED
     * If there is chaos - more than 60 vehicles - 30 + 30 vehicles move in one round
     * If there are no vehicles, skip and move to next road
     */
    public void startTrafficManagement() {
        Map<String, String> progress = new HashMap<>();

        while (true) {

            for (Map.Entry<String, Traffic> traffic : trafficSystem.entrySet()) {
                int straightAndLeftTraffic = traffic.getValue().getStraightAndLeftTraffic();
                int straightAndRightTraffic = traffic.getValue().getStraightAndRightTraffic();
                System.out.println("\nRoad: " + traffic.getKey() + " Straight And Left " + straightAndLeftTraffic
                        + " Straight And Right " + straightAndRightTraffic);

                // No vehicles, skip
                if (progress.size() == trafficSystem.size())
                    exit(0);
                else if (straightAndLeftTraffic == 0 && straightAndRightTraffic == 0) {
                    if (progress.get(traffic.getKey()) == null) {
                        progress.put(traffic.getKey(), "DONE");
                        continue;
                    }
                } else if (straightAndLeftTraffic < 10
                        && straightAndRightTraffic < 10) {
                    // If we have less than 10 vehicles, turn to RED after all vehicles pass
                    traffic.getValue().letTrafficGo(Math.max(
                            traffic.getValue().getStraightAndLeftTraffic(),
                            traffic.getValue().getStraightAndRightTraffic()));
                } else if (straightAndLeftTraffic < 30
                        || straightAndRightTraffic < 30) {
                    // Green light for 10 seconds
                    traffic.getValue().letTrafficGo(10);
                } else if (straightAndLeftTraffic >= 60
                        && straightAndRightTraffic >= 60) {
                    traffic.getValue().letTrafficGo(30);
                }

                straightAndLeftTraffic = traffic.getValue().getStraightAndLeftTraffic();
                straightAndRightTraffic = traffic.getValue().getStraightAndRightTraffic();
                System.out.println(("Remaining - Road: " + traffic.getKey() + " Straight And Left " + straightAndLeftTraffic
                        + " Straight And Right " + straightAndRightTraffic));
            }
        }
    }
}

