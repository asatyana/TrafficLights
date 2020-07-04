package com.ananth.traffic;

import java.util.LinkedList;
import java.util.Queue;

public class Traffic {
    private Queue<Vehicle> straightAndRight = null;
    private Queue<Vehicle> straightAndLeft = null;
    private final String direction;
    private final TrafficLightPole lightPole;

    /**
     *
     * @param direction - Road name
     * @param straightAndRight - No of vehicles going Straight an Right
     * @param straightAndLeft - No of vehicles going Straight an Right
     */
    public Traffic(String direction, int straightAndRight, int straightAndLeft) {
        this.direction = direction;
        this.lightPole = new TrafficLightPole(direction);

        buildOrAddStraightAndLeftTraffic(straightAndLeft);
        buildOrAddStraightAndRightTraffic(straightAndRight);
    }

    /**
     * Build the queue of vehicles that go straight and left at the traffic junction
     * @param noOfVehicles - No of vehicles
     */
    public void buildOrAddStraightAndLeftTraffic(int noOfVehicles) {
        if (this.straightAndLeft == null)
            this.straightAndLeft = new LinkedList<>();
        for(int i = 0; i < noOfVehicles; i++) {
            this.straightAndLeft.add(new Vehicle(i));
        }
    }

    /**
     * Build the queue of vehicles that go straight and right at the traffic junction
     * @param noOfVehicles - No of vehicles
     */
    public void buildOrAddStraightAndRightTraffic(int noOfVehicles) {
        if (this.straightAndRight == null)
            this.straightAndRight = new LinkedList<>();
        for(int i = 0; i < noOfVehicles; i++) {
            this.straightAndRight.add(new Vehicle(i));
        }
    }

    /**
     * Let the traffic flow. Turn the green light and stop after the specified duration to stop traffic
     * Assuming 1 vehicle crosses the signal in 1 second
     */
    public void letTrafficGo(int noOfVehicles) {
        this.lightPole.letTrafficGo(noOfVehicles);
        for (int i = 0; i < noOfVehicles; i++) {
            if (!this.straightAndRight.isEmpty())
                this.straightAndRight.remove();
            if (!this.straightAndLeft.isEmpty())
                this.straightAndLeft.remove();
        }
    }

    public int getStraightAndRightTraffic() {
        return straightAndRight.size();
    }

    public int getStraightAndLeftTraffic() {
        return straightAndLeft.size();
    }
}
