package com.example.metrics;

public class SensorDataWrapper {

    /***************************************************************************
     *                                                                         *
     * Fields                                                                  *
     *                                                                         *
     **************************************************************************/

    PartectorData partectorData;
    GatewayData gatewayData;
    LocationData locationData;
    int timestamp;
    String deviceName;

    /***************************************************************************
     *                                                                         *
     * Constructor                                                             *
     *                                                                         *
     **************************************************************************/

    public SensorDataWrapper(PartectorData partectorData, GatewayData gatewayData, LocationData locationData,
                             int timestamp, String deviceName) {
        this.partectorData = partectorData;
        this.gatewayData = gatewayData;
        this.locationData = locationData;
        this.timestamp = timestamp;
        this.deviceName = deviceName;
    }

    /***************************************************************************
     *                                                                         *
     * Getters / Setters                                                       *
     *                                                                         *
     **************************************************************************/

    public PartectorData getPartectorData() {
        return partectorData;
    }

    public void setPartectorData(PartectorData partectorData) {
        this.partectorData = partectorData;
    }

    public GatewayData getGatewayData() {
        return gatewayData;
    }

    public void setGatewayData(GatewayData gatewayData) {
        this.gatewayData = gatewayData;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    public void setLocationData(LocationData locationData) {
        this.locationData = locationData;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
