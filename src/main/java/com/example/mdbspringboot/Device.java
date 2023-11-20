package com.example.mdbspringboot;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "devices")
public class Device {

    @Id
    private String id;

    private String DEVEUI;
    private String deviceNbr;
    private String timestamp;
    private String temp;
    private String humidity;
    private String lum;

    public Device(String id, String DEVEUI, String deviceNbr, String timestamp, String temp, String humidity, String lum) {
        this.id = id;
        this.DEVEUI = DEVEUI;
        this.deviceNbr = deviceNbr;
        this.timestamp = timestamp;
        this.temp = temp;
        this.humidity = humidity;
        this.lum = lum;
    }

    public Device() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDEVEUI() {
        return DEVEUI;
    }

    public void setDEVEUI(String DEVEUI) {
        this.DEVEUI = DEVEUI;
    }

    public String getDeviceNbr() {
        return deviceNbr;
    }

    public void setDeviceNbr(String deviceNbr) {
        this.deviceNbr = deviceNbr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLum() {
        return lum;
    }

    public void setLum(String lum) {
        this.lum = lum;
    }

    @Override
    public String toString(){
        return "Device [id="+id+", DEVEUI="+DEVEUI+", deviceNbr="+deviceNbr+", timestamp="+timestamp+", temp="+temp+", humidity="+humidity+", lum="+lum+"]";
    }
}
