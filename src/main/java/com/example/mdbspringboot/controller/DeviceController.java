package com.example.mdbspringboot.controller;

import com.example.mdbspringboot.Device;
import com.example.mdbspringboot.Data.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:8082")
@RestController
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    DeviceRepository deviceRepository;

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getAllDevice(@RequestParam(required = false) String device) {
        try{
            List<Device> devices = new ArrayList<Device>();

            if (device == null)
                deviceRepository.findAll().forEach(devices::add);
            else
                deviceRepository.findByDEVEUIContaining(device).forEach(devices::add);

            if (devices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(devices,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/devices/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") String id) {
        Optional<Device> deviceData = deviceRepository.findById((id));

        if (deviceData.isPresent()) {
            return new ResponseEntity<>(deviceData.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/devices/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable("id") String id, @RequestBody Device device) {
        Optional<Device> deviceData = deviceRepository.findById(id);

        if (deviceData.isPresent()) {
            Device _device = deviceData.get();
            _device.setId(device.getId());
            _device.setDeviceNbr(device.getDeviceNbr());
            _device.setDEVEUI(device.getDEVEUI());
            _device.setTemp(device.getTemp());
            _device.setHumidity(device.getHumidity());
            _device.setLum(device.getLum());
            return new ResponseEntity<>(deviceRepository.save(_device), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    @DeleteMapping("/devices/{id}")
    public ResponseEntity<HttpStatus> deleteDevice(@PathVariable("id") String id) {

    }

    @DeleteMapping("/devices")
    public ResponseEntity<HttpStatus> deleteAllDevices() {

    }
*/
    /*
    @GetMapping("/devices/DEVEUI")
    public ResponseEntity<List<Device>> findByDEVEUI(@PathVariable("DEVEUI") String deveui) {
        Optional<Device> deviceData = deviceRepository.findByDEVEUI((deveui));

        if (deviceData.isPresent()) {
            return new ResponseEntity<>(deviceData.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    */

    @PostMapping("/devices")
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        try {       
            Device _device = deviceRepository.save(new Device(device.getId(), device.getDEVEUI(), device.getDeviceNbr(), device.getTimestamp(), device.getTemp(), device.getHumidity(), device.getLum()));
            return new ResponseEntity<>(_device, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
