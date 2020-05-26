package com.example.metrics;

import java.util.List;

public class MetricDataWrapper {

    /***************************************************************************
     *                                                                         *
     * Fields                                                                  *
     *                                                                         *
     **************************************************************************/

    StaticGateway staticGateway;
    List<SensorDataWrapper> values;

    /***************************************************************************
     *                                                                         *
     * Constructor                                                             *
     *                                                                         *
     **************************************************************************/

    public MetricDataWrapper(StaticGateway staticGateway, List<SensorDataWrapper> values) {
        this.staticGateway = staticGateway;
        this.values = values;
    }

    /***************************************************************************
     *                                                                         *
     * Getters / Setters                                                       *
     *                                                                         *
     **************************************************************************/

    public StaticGateway getStaticGateway() {
        return staticGateway;
    }

    public void setStaticGateway(StaticGateway staticGateway) {
        this.staticGateway = staticGateway;
    }

    public List<SensorDataWrapper> getValues() {
        return values;
    }

    public void setValues(List<SensorDataWrapper> values) {
        this.values = values;
    }
}
