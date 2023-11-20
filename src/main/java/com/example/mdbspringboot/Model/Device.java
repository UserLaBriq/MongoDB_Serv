package com.example.mdbspringboot.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    @Id
    private String id;

    private String DEVEUI;
    private String device;
    private String timestamp;
    private String temperature;
    private String humidite;
    private String luminosite;

}
