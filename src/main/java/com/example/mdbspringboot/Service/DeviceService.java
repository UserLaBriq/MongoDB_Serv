package com.example.mdbspringboot.Service;


import com.example.mdbspringboot.Model.Device;
import com.example.mdbspringboot.Repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repository;

    //CRUD CREATE, READ, UPDATE, DELETE

    public Device addDevice(Device device) {
        device.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(device);
    }

    public List<Device> findAllDevices() {
        return repository.findAll();
    }

    public Device getDeviceByDeviceId(String Id){
        return repository.findById(Id).get();
    }

    public List<Device> getDeviceByDEVEUI(String DEVEUI){
        return repository.getDevicesByDEVEUI(DEVEUI);
    }

    public Device updateDevice(Device deviceRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Device existingDevice = repository.findById(deviceRequest.getId()).get();
        existingDevice.setDEVEUI(deviceRequest.getDEVEUI());
        existingDevice.setDevice(deviceRequest.getDevice());
        existingDevice.setTimestamp(deviceRequest.getTimestamp());
        existingDevice.setTemperature(deviceRequest.getTemperature());
        existingDevice.setHumidite(deviceRequest.getHumidite());
        existingDevice.setLuminosite(deviceRequest.getLuminosite());

        return repository.save(existingDevice);
    }

    public String deleteDevice(String Id){
        repository.deleteById(Id);
        return Id+" task deleted from dashboard ";
    }
}
