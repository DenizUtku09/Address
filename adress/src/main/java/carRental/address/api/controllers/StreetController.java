package carRental.address.api.controllers;

import carRental.address.business.abstracts.StreetService;
import carRental.address.entities.concretes.Street;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Street")
public class StreetController {

    private StreetService streetService;

    @PostMapping("/addStreet")
    public Street addStreet(@RequestBody Street street){
        return streetService.addStreet(street);
    }
    @GetMapping("/getAllStreets")
    public List<Street> getAllStreets(){
        return streetService.getAllStreets();
    }

}
