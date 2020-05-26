package com.example.metrics;

public class GatewayData {

    /***************************************************************************
     *                                                                         *
     * Fields                                                                  *
     *                                                                         *
     **************************************************************************/

    int battery;
    int freeMemory;
    int cellularSignal;

    /***************************************************************************
     *                                                                         *
     * Constructor                                                             *
     *                                                                         *
     **************************************************************************/

    public GatewayData(int battery, int freeMemory, int cellularSignal) {
        this.battery = battery;
        this.freeMemory = freeMemory;
        this.cellularSignal = cellularSignal;
    }

    /***************************************************************************
     *                                                                         *
     * Getters / Setters                                                       *
     *                                                                         *
     **************************************************************************/

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }

    public int getCellularSignal() {
        return cellularSignal;
    }

    public void setCellularSignal(int cellularSignal) {
        this.cellularSignal = cellularSignal;
    }
}
