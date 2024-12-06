package com.threemtt.vmis.service;

import com.threemtt.vmis.dto.request.CarRequest;
import com.threemtt.vmis.dto.response.CarResponse;
import com.threemtt.vmis.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    CarResponse registerCar(CarRequest carRequest) throws Exception;

    List<Car> carsList();

    Optional<Car> findACar(String plateNumber);

    Optional<Car> updateFlagged(String plateNumber, boolean flaggedStatus);

}
