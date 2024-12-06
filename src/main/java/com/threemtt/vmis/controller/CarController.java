package com.threemtt.vmis.controller;

import com.threemtt.vmis.dto.request.CarRequest;
import com.threemtt.vmis.dto.response.CarResponse;
import com.threemtt.vmis.model.Car;
import com.threemtt.vmis.service.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarServiceImpl carService;

    @PostMapping("/register")
    public ResponseEntity<CarResponse> registerCars(@Valid @RequestBody CarRequest carRequest) throws Exception {
        return new ResponseEntity<>(carService.registerCar(carRequest), HttpStatus.CREATED);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(carService.carsList(), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Optional<Car>> findACar(@RequestParam String plateNumber){
        return new ResponseEntity<>(carService.findACar(plateNumber), HttpStatus.OK);
    }

    @PatchMapping("/{plateNumber}/update-flagged")
    public ResponseEntity<Optional<Car>> updateFlagged(@Valid @PathVariable String plateNumber, @RequestParam boolean flagged) {
        return new ResponseEntity<>(carService.updateFlagged(plateNumber, flagged), HttpStatus.OK);
    }
}
