package com.example.metrics;

public class PartectorData {

    /***************************************************************************
     *                                                                         *
     * Fields                                                                  *
     *                                                                         *
     **************************************************************************/

    float ldsa;
    int average_particle_diameter;
    int particle_number_concentration;
    int temperature;
    int relative_humidity;
    int device_status;
    float battery_voltage;
    int serial_number;
    float particle_mass;

    /***************************************************************************
     *                                                                         *
     * Constructor                                                             *
     *                                                                         *
     **************************************************************************/

    public PartectorData(float ldsa, int average_particle_diameter, int particle_number_concentration,
                         int temperature, int relative_humidity, int device_status, float battery_voltage,
                         int serial_number, float particle_mass) {
        this.ldsa = ldsa;
        this.average_particle_diameter = average_particle_diameter;
        this.particle_number_concentration = particle_number_concentration;
        this.temperature = temperature;
        this.relative_humidity = relative_humidity;
        this.device_status = device_status;
        this.battery_voltage = battery_voltage;
        this.serial_number = serial_number;
        this.particle_mass = particle_mass;
    }

    /***************************************************************************
     *                                                                         *
     * Getters / Setters                                                       *
     *                                                                         *
     **************************************************************************/

    public float getLdsa() {
        return ldsa;
    }

    public void setLdsa(float ldsa) {
        this.ldsa = ldsa;
    }

    public int getAverage_particle_diameter() {
        return average_particle_diameter;
    }

    public void setAverage_particle_diameter(int average_particle_diameter) {
        this.average_particle_diameter = average_particle_diameter;
    }

    public int getParticle_number_concentration() {
        return particle_number_concentration;
    }

    public void setParticle_number_concentration(int particle_number_concentration) {
        this.particle_number_concentration = particle_number_concentration;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getRelative_humidity() {
        return relative_humidity;
    }

    public void setRelative_humidity(int relative_humidity) {
        this.relative_humidity = relative_humidity;
    }

    public int getDevice_status() {
        return device_status;
    }

    public void setDevice_status(int device_status) {
        this.device_status = device_status;
    }

    public float getBattery_voltage() {
        return battery_voltage;
    }

    public void setBattery_voltage(float battery_voltage) {
        this.battery_voltage = battery_voltage;
    }

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public float getParticle_mass() {
        return particle_mass;
    }

    public void setParticle_mass(float particle_mass) {
        this.particle_mass = particle_mass;
    }
}

