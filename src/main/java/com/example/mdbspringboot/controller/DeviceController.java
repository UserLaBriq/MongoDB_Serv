package com.example.mdbspringboot.controller;

import com.example.mdbspringboot.Model.Device;
import com.example.mdbspringboot.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device createDevice(@RequestBody Device device){
        return service.addDevice(device);
    }

    @GetMapping
    public List<Device> getDevices() {
        return service.findAllDevices();
    }

    @GetMapping("/{Id}")
    public Device getDevice(@PathVariable String Id){
        return service.getDeviceByDeviceId(Id);
    }

    @GetMapping("/DEVEUI/{DEVEUI}")
    public List<Device> getDeviceByDEVEUI(@PathVariable String DEVEUI){
        return service.getDeviceByDEVEUI(DEVEUI);
    }

    @PutMapping
    public Device modifyDevice(@RequestBody Device device){
        return service.updateDevice(device);
    }

    @DeleteMapping("/{Id}")
    public String deleteDevice(@PathVariable String Id){
        return service.deleteDevice(Id);
    }
}
