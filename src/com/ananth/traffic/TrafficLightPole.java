package com.ananth.traffic;

public class TrafficLightPole {

    private final String poleId;
    public static final String TRAFFIC_LIGHT_RED = "RED";
    public static final String TRAFFIC_LIGHT_YELLOW = "YELLOW";
    public static final String TRAFFIC_LIGHT_GREEN = "GREEN";

    private String trafficLight;

    public TrafficLightPole(String poleId) {
        this.poleId = poleId;
        this.trafficLight = TRAFFIC_LIGHT_RED;
    }

    public String getPoleId() {
        return poleId;
    }

    public boolean letTrafficGo(int NumOfVehicles) {
        if (this.trafficLight.equals(TRAFFIC_LIGHT_RED)) {
                System.out.print(this.trafficLight);
                this.trafficLight = TRAFFIC_LIGHT_YELLOW;
                tick(2);
                this.trafficLight = TRAFFIC_LIGHT_GREEN;
                tick(NumOfVehicles);
                this.trafficLight = TRAFFIC_LIGHT_YELLOW;
                tick(2);
                this.trafficLight = TRAFFIC_LIGHT_RED;
                System.out.println(" " + this.trafficLight);
                return true;
            }
        return false;
    }

    private void tick(int count) {
        System.out.print(" " + this.trafficLight + " ");
        try {
            for (int i = 0; i < count; i++) {
                System.out.print(".");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
