package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Models.Car;
import web.sevices.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(Model model, @RequestParam(required = false) Integer count) {
        List<Car> cars;
        if (count == null || count >= 5) {
            cars = carService.getAllCars();
        } else {
            cars = carService.getCars(count);
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
