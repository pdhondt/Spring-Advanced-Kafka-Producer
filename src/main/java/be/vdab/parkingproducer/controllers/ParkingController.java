package be.vdab.parkingproducer.controllers;

import be.vdab.parkingproducer.services.ParkingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parkings")
public class ParkingController {
    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }
    private record VrijePlaatsen(@Positive int plaatsen) {}
    @PatchMapping("{naam}/vrijeplaatsen")
    void updateVrijePlaatsen(@PathVariable String naam,
                             @RequestBody @Valid VrijePlaatsen vrijePlaatsen) {
        parkingService.updateVrijePlaatsen(naam, vrijePlaatsen.plaatsen());
    }
}
