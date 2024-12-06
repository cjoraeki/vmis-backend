package com.threemtt.vmis.service;

import com.threemtt.vmis.dto.request.CarRequest;
import com.threemtt.vmis.dto.response.CarResponse;
import com.threemtt.vmis.model.Car;
import com.threemtt.vmis.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    @Override
    public CarResponse registerCar(CarRequest carRequest) throws Exception {
        if (carRepository.findByPlateNumber(carRequest.getPlateNumber()).isPresent()){
            throw new Exception("Car already exists. Go to search");
        }
        Car car = new Car();
        car.setCarModel(carRequest.getCarModel());
        car.setPlateNumber(carRequest.getPlateNumber());
        car.setCarOwner(carRequest.getCarOwner());
        car.setNin(carRequest.getNin());
        car.setDriversLicense(carRequest.getDriversLicense());
        car.setDescription(carRequest.getDescription());
        car.setEngineNumber(carRequest.getEngineNumber());
        car.setYearOfManufacture(carRequest.getYearOfManufacture());
        car.setColor(carRequest.getColor());
        car.setFlagged(false);

        carRepository.save(car);
        CarResponse carResponse = new CarResponse();
        BeanUtils.copyProperties(car, carResponse);

        return carResponse;
    }

    @Override
    public List<Car> carsList() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findACar(String plateNumber) {
        return carRepository.findByPlateNumber(plateNumber);
    }

    @Override
    public Optional<Car> updateFlagged(String plateNumber, boolean flaggedStatus) {
        Optional<Car> carOptional = carRepository.findByPlateNumber(plateNumber);

        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            car.setFlagged(flaggedStatus);
            car.setUpdatedAt(LocalDateTime.now());
            carRepository.save(car);
            return Optional.of(car);
        } else {
            return Optional.empty();
        }
    }
}
