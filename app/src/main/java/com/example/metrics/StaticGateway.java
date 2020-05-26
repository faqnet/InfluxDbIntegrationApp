package com.example.metrics;

public class StaticGateway {

    int deviceID;
    int firmwareVersion;
    String type;

    public StaticGateway(int deviceID, int firmwareVersion, String type) {
        this.deviceID = deviceID;
        this.firmwareVersion = firmwareVersion;
        this.type = type;
    }
}
