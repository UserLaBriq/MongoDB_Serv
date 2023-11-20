package com.example.mdbspringboot.Repository;

import com.example.mdbspringboot.Model.Device;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DeviceRepository
    extends MongoRepository<Device, String>{
    @Query("{ DEVEUI: ?0 }")
    List<Device> getDevicesByDEVEUI(String DEVEUI);
    }

