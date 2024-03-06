package web.sevices;

import org.springframework.stereotype.Service;
import web.Models.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final List<Car> cars = Arrays.asList(
            new Car("Toyota", "Camry", 2020),
            new Car("Honda", "Accord", 2019),
            new Car("Ford", "Mustang", 2021),
            new Car("Chevrolet", "Camaro", 2022),
            new Car("BMW", "X5", 2023)
    );

    public List<Car> getAllCars() {
        return cars;
    }

    public List<Car> getCars(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}

