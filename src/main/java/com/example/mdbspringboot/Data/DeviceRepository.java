package com.example.mdbspringboot.Data;

import com.example.mdbspringboot.Device;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository
    extends MongoRepository<Device, String>{
        List<Device> findByDEVEUIContaining(String DEVEUI);
        //List<Device> findByDeviceNbrContaining(String deviceNbr);
    }

